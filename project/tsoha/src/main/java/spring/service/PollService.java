/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.service;

import java.util.List;
import spring.domain.Poll;
import spring.domain.User;

/**
 *
 * @author kviiri
 */
public interface PollService {
    public void save(Poll p);
    public void saveOrUpdate(Poll p, Long id);
    public Poll findOne(Long id);
    public void remove(Poll p);
    public List<Poll> list();
    
    public boolean vote(User u, Long optionId);
}
