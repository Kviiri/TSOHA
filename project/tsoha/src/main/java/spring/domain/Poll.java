
package spring.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author kviiri
 */
@Entity(name = "POLLS")
public class Poll implements Serializable {
    @OneToMany(mappedBy="poll", cascade={CascadeType.REMOVE, CascadeType.PERSIST})
    private List<PollOption> pollOptions;
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    @ManyToOne
    private User author;
    
    private String title;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PollOption> getPollOptions() {
        return pollOptions;
    }

    public void setPollOptions(List<PollOption> pollOptions) {
        this.pollOptions = pollOptions;
    }
    
    public int getNumOfAnswers() {
        int answers = 0;
        for(PollOption p : pollOptions) {
            answers += p.getVotes().size();
        }
        return answers;
    }
    
    
    
}
