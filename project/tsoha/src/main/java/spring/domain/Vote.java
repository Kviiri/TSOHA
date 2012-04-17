/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author kviiri
 */
@Entity (name = "VOTES")
public class Vote implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private PollOption option;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date voteTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PollOption getOption() {
        return option;
    }

    public void setOption(PollOption option) {
        this.option = option;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getVoteTime() {
        return voteTime;
    }

    public void setVoteTime(Date voteTime) {
        this.voteTime = voteTime;
    }
    
}
