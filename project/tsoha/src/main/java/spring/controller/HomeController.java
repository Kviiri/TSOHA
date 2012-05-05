package spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.domain.Poll;
import spring.domain.Role;
import spring.domain.User;
import spring.domain.Vote;
import spring.domain.form.CreateUserForm;
import spring.repository.UserRepository;
import spring.service.PollService;
import spring.service.PollUserDetailsServiceImplementation;
import spring.service.SecureService;

@Controller
public class HomeController {

    
    @Autowired
    UserRepository urepo;
    @Autowired
    SecureService secureService;
    @Autowired
    PollService pServ;
    
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
                if (r.getRolename().equals("user")) {
                    normiuserit.add(u);
                    break;
                }
            }
        }
        model.addAttribute("user", normiuserit);
        return "home";
    }

    @RequestMapping(value = "/must-be-authenticated")
    public String mustAuth() {
        secureService.executeOnlyIfAuthenticated();
        return "home";
    }

    @RequestMapping(value = "/must-be-admin")
    public String mustAdmin() {
        secureService.executeOnlyIfAuthenticatedAsAdmin();
        return "home";
    }
    
    @RequestMapping(value = "listpolls")
    public String listPolls(Model model) {
        model.addAttribute("polls", pServ.list());
        return "listing/listpolls";
    }
    
    @RequestMapping(value = "createuser", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("userForm", new CreateUserForm());
        return "register";
    }
    
    @RequestMapping(value = "createuser", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("userForm") CreateUserForm userForm, BindingResult result) {
        userForm.validatePasswordEqualsConfirmedPassword(result);
        if (result.hasErrors()) {
            return "register";
        }
        User user = new User();
        user.setName(userForm.getName());
        user.setUsername(userForm.getUsername());
        user.setPassword(userForm.getPassword());
        List<Role> list = new ArrayList<Role>();
        list.add(PollUserDetailsServiceImplementation.getUserRole());
        user.setRoles(list);
        user.setMemberSince(new Date(System.currentTimeMillis()));
        List<Poll> polls = new ArrayList<Poll>();
        user.setPolls(polls);
        List<Vote> votes = new ArrayList<Vote>();
        user.setVotes(votes);
        urepo.save(user);
        return "redirect:/home";
    }
    
    @RequestMapping(value="*")
    public String defaultForwardToHome() {
        return "redirect:/home";
    }
}
