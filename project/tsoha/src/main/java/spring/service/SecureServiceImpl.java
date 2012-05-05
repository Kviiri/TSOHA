package spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.domain.Role;
import spring.domain.User;
import spring.repository.UserRepository;

@Service
public class SecureServiceImpl implements SecureService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PollUserDetailsService userv;

    @Override
    public void executeOnlyIfAuthenticatedAsAdmin() {
        System.out.println("The guy must be an admin! Note that this was configured in the interface.");
    }

    @Override
    public void executeOnlyIfAuthenticated() {
        System.out.println("The guy must be authenticated! Note that this was configured in the interface.");
    }

    @Override
    @Transactional
    public void executeFreely() {
        // populate db if needed
        if (userRepository.count() > 0) {
            return;
        }

        User matti = new User();
        matti.setUsername("matti");
        matti.setName("Macho Luukkandez");
        matti.setPassword("bonus");


        List<Role> roles = new ArrayList();
        roles.add(userv.getAdminRole());
        roles.add(userv.getUserRole());
        
        
        matti.setRoles(roles);
        
        userRepository.save(matti);
    }
}
