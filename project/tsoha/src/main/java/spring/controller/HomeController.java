package spring.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.domain.Role;
import spring.domain.User;
import spring.repository.UserRepository;
import spring.service.SecureService;

@Controller
public class HomeController {

    
    @Autowired
    UserRepository urepo;
    @Autowired
    SecureService secureService;
    @RequestMapping(value = "login", method=RequestMethod.GET)
    public String login() {
        return "login";
    }
    
    @RequestMapping(value = "/home")
    public String home(Model model) {
        secureService.executeFreely();
        List<User> users = urepo.findAll();
        List<User> normiuserit = new ArrayList<User>();
        for (User u : users) {
            for (Role r : u.getRoles()) {
                if (r.getRolename().equals("student")) {
                    normiuserit.add(u);
                    break;
                }
            }
        }
        model.addAttribute("students", normiuserit);
        return "home";
    }

    @RequestMapping(value = "/must-be-authenticated")
    public String mustAuth() {
        secureService.executeOnlyIfAuthenticated();
        return "home";
    }

    @RequestMapping(value = "/must-be-admin")
    public String mustAdmin() {
        secureService.executeOnlyIfAuthenticatedAsLecturer();
        return "home";
    }
    @RequestMapping(value = "*")
    public String defaultForwardToHome() {
        return "redirect:/home";
    }
}
