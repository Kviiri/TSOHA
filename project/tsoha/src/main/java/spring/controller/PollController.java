/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.domain.User;
import spring.service.PollService;
import spring.service.PollUserDetailsService;
import spring.service.PollUserDetailsServiceImplementation;

/**
 *
 * @author kviiri
 */
@Controller
@RequestMapping("/poll")
public class PollController {

    @Autowired
    PollService pserv;
    @Autowired
    PollUserDetailsService userv;

    @RequestMapping("vote/{optionID}")
    public String vote(@PathVariable Long optionID, Principal principal, Model model) {
        if (principal == null) {
            model.addAttribute("voteMessage", "Sinun pitää kirjautua sisään jotta voit äänestää.");
        } else {
            User u = userv.simpleLoadUserByUsername(principal.getName());
            if (u == null || !u.getRoles().contains(userv.getUserRole())) {
                model.addAttribute("voteMessage", "Käyttöoikeutesi eivät riitä äänestämiseen.");
            } else {
                if (pserv.vote(u, optionID)) {
                    model.addAttribute("voteMessage", "Äänesi on rekisteröity!");
                } else {
                    model.addAttribute("voteMessage", "Olet jo äänestänyt tähän kyselyyn.");
                }
            }
        }
        model.addAttribute("polls", pserv.list());
        return "listing/listpolls";
    }
}
