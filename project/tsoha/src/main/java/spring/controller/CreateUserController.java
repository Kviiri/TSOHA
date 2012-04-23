package spring.controller;

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
import spring.domain.Role;
import spring.domain.User;
import spring.domain.form.CreateUserForm;
import spring.repository.UserRepository;

@Controller
public class CreateUserController {

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String registerForm(Model model) {
        return "register";
    }
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute CreateUserForm userForm, BindingResult result) {
        if (result.hasErrors()) {
            return "home";
        }
        User user = new User();
        user.setName(userForm.getName());
        user.setUsername(userForm.getUsername());
        Role role = new Role();
        role.setRolename("user");
        List<Role> list = new ArrayList<Role>();
        list.add(role);
        user.setRoles(list);
        userRepo.save(user);
        return "redirect:/home";
    }
}