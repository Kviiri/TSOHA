package spring.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.domain.Poll;
import spring.domain.PollOption;
import spring.domain.form.QuickAndDirtyCreatePollForm;
import spring.repository.PollRepository;
import spring.repository.UserRepository;
import spring.service.PollService;
import spring.service.PollUserDetailsService;

@Controller
@RequestMapping("/user")
public class UserController {

    PollUserDetailsService uServ;
    
    @Autowired
    PollService pServ;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(Model model, Principal principal) {
        //model.addAttribute("user", uServ.loadUserByUsername(principal.getName()));
        return "user/home";
    }
    
    @RequestMapping(value = "addpoll", method = RequestMethod.GET) 
    public String showPollForm(Model model) {
        return "user/addpoll";
    }
    
    @RequestMapping(value = "addpoll", method = RequestMethod.POST) 
    public String createPoll(@ModelAttribute QuickAndDirtyCreatePollForm cpf) {
        List<PollOption> options = new ArrayList<PollOption>();
        PollOption p1 = new PollOption();
        PollOption p2 = new PollOption();
        PollOption p3 = new PollOption();
        PollOption p4 = new PollOption();
        p1.setOptionDescription(cpf.getPollOption1());
        p2.setOptionDescription(cpf.getPollOption2());
        p3.setOptionDescription(cpf.getPollOption3());
        p4.setOptionDescription(cpf.getPollOption4());
        options.add(p1);
        options.add(p2);
        options.add(p3);
        options.add(p4);
        
        
        
        Poll p = new Poll();
        p.setPollOptions(options);
        p.setTitle(cpf.getPollQuestion());
        pServ.saveOrUpdate(p, p.getId());
        return "redirect:home";
    }
}