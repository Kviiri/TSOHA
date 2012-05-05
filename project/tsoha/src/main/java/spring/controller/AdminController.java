package spring.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.domain.User;
import spring.repository.UserRepository;
import spring.service.PollService;
import spring.service.PollUserDetailsService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    PollService pserv;
    @Autowired
    PollUserDetailsService userv;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("polls", pserv.list());
        return "admin/home";
    }

    @RequestMapping(value = "delete/{pollID}")
    public String deletePoll(@PathVariable Long pollID, Principal principal, Model model) {
        if (principal == null) {
            model.addAttribute("deleteMessage", "Et ole autentikoitunut!");
        } else {
            User u = userv.simpleLoadUserByUsername(principal.getName());
            if (u == null || !u.getRoles().contains(userv.getAdminRole())) {
                model.addAttribute("deleteMessage", "Et ole autentikoitunut!");
            } else {
                pserv.remove(pserv.findOne(pollID));
                model.addAttribute("deleteMessage", "Kysely poistettu!");
            }
        }
        model.addAttribute("polls", pserv.list());
        return "admin/home";
    }
}