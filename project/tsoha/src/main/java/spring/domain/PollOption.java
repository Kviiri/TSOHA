package spring.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author kviiri
 */
@Entity(name = "PollOptions")
public class PollOption implements Serializable {
    @OneToMany(mappedBy="option", cascade={CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Vote> votes;
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    @ManyToOne
    private Poll poll;
    
    
    private String optionDescription;

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionDescription() {
        return optionDescription;
    }

    public void setOptionDescription(String optionDescription) {
        this.optionDescription = optionDescription;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
    
    public void addVote(Vote v) {
        votes.add(v);
    }
    
    public int getNumOfVotes() {
        return votes.size();
    }
}
