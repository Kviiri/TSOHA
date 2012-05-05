/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.domain.PollOption;

/**
 *
 * @author kviiri
 */
public interface PollOptionRepository extends JpaRepository<PollOption, Long> {
    
}
