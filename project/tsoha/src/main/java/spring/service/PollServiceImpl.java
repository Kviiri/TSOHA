/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.domain.Poll;
import spring.repository.PollRepository;

/**
 *
 * @author kviiri
 */
@Service
public class PollServiceImpl implements PollService {

    @Autowired
    PollRepository repo;
    
    @Override
    @Transactional
    public void saveOrUpdate(Poll p, Long id) {
        if(repo.exists(id)) {
            repo.delete(p);
        }
        repo.saveAndFlush(p);
    }

    @Override
    @Transactional
    public Poll findOne(Long id) {
        return repo.findOne(id);
    }

    @Override
    @Transactional
    public void remove(Poll p) {
        repo.delete(p);
    }

    @Override
    @Transactional
    public List<Poll> list() {
        return repo.findAll();
    }

    @Override
    public void save(Poll p) {
        repo.save(p);
    }
    
}
