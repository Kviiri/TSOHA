/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import spring.domain.Role;
import spring.domain.User;

/**
 *
 * @author kviiri
 */
public interface PollUserDetailsService extends UserDetailsService {

    @Transactional
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    @Transactional
    User simpleLoadUserByUsername(String username);
    
    Role getUserRole();
    Role getAdminRole();
    
}
