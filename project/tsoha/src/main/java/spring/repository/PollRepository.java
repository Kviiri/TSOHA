/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.domain.Poll;

/**
 *
 * @author kviiri
 */
public interface PollRepository extends JpaRepository<Poll, Long> {
    
}
