package spring.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.domain.Poll;
import spring.domain.PollOption;
import spring.domain.form.CreatePollForm;
import spring.service.PollService;
import spring.service.PollUserDetailsServiceImplementation;

@Controller
@RequestMapping("/user")
public class UserController {

    PollUserDetailsServiceImplementation uServ;
    
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
    public String createPoll(@Valid @ModelAttribute("pollForm") CreatePollForm cpf, BindingResult result, Model model) {
        cpf.validatePollOptions(result);
        if(result.hasErrors()) {
            return "user/addpoll";
        }
        List<PollOption> options = new ArrayList<PollOption>();
        
        Poll p = new Poll();
        for(String s : cpf.getPollOptions()) {
            PollOption po = new PollOption();
            po.setOptionDescription(s);
            options.add(po);
            po.setPoll(p);
        }
        
        p.setPollOptions(options);
        p.setTitle(cpf.getPollQuestion());
        pServ.saveOrUpdate(p, p.getId());
        model.addAttribute("voteMessage", "Kyselysi on lisätty!");
        
        model.addAttribute("polls", pServ.list());
        return "listing/listpolls";
    }
}