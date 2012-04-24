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
    @OneToMany(mappedBy = "option")
    private List<Vote> votes;
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    
    private String optionDescription;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
