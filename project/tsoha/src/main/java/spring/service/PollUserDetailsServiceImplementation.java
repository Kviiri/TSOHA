package spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.domain.Role;
import spring.domain.User;
import spring.repository.UserRepository;

@Service
public class PollUserDetailsServiceImplementation implements PollUserDetailsService {

    
    
    @Override
    public Role getAdminRole() {
        Role adminRole = new Role();
        adminRole.setRolename("admin");
        return adminRole;
    }
    
    @Override
    public Role getUserRole() {
        Role userRole = new Role();
        userRole.setRolename("user");
        return userRole;
    }
    
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                getRolesAsGrantedAuthorities(user.getRoles()));
    }

    @Transactional
    @Override
    public User simpleLoadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    private List<GrantedAuthority> getRolesAsGrantedAuthorities(List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
        }
        return authorities;
    }
    
    
}
