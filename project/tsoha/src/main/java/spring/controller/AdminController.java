package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(Model model) {
        return "admin/home";
    }
    
}