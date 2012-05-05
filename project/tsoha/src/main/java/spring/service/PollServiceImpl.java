/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.domain.Poll;
import spring.domain.PollOption;
import spring.domain.User;
import spring.domain.Vote;
import spring.repository.PollOptionRepository;
import spring.repository.PollRepository;
import spring.repository.UserRepository;

/**
 *
 * @author kviiri
 */
@Service
public class PollServiceImpl implements PollService {

    @Autowired
    private PollRepository repo;
    
    @Autowired
    private PollOptionRepository optionrepo;
    
    @Autowired
    private UserRepository urepo;
    
    @Override
    @Transactional
    public void saveOrUpdate(Poll p, Long id) {
        repo.saveAndFlush(p);
        for(PollOption o : p.getPollOptions()) {
            optionrepo.save(o);
        }
        optionrepo.flush();
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
    @Transactional
    public void save(Poll p) {
        repo.save(p);
    }
    
    
    @Transactional
    @Override
    public boolean vote(User u, Long optionID) {
        PollOption voteTarget = optionrepo.findOne(optionID);
        Poll p = voteTarget.getPoll();
        for(Vote v : u.getVotes()) {
            if(v.getOption().getPoll().getId().equals(p.getId())) {
                return false;
            }
        }
        Vote v = new Vote();
        v.setUser(u);
        v.setOption(voteTarget);
        v.setVoteTime(new Date(System.currentTimeMillis()));
        voteTarget.addVote(v);
        saveOrUpdate(p, p.getId());
        u.getVotes().add(v);
        urepo.saveAndFlush(u);
        return true;
    }
}
