/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.domain.form;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.AutoPopulatingList;

/**
 *
 * @author kviiri
 * 
 * HAHAHAHAHA LOOK AT THIS CLASS
 */
public class QuickAndDirtyCreatePollForm {
    @NotNull
    @NotEmpty
    String pollQuestion;
    @NotNull
    @NotEmpty
    String pollOption1;
    
    String pollOption2;
    String pollOption3;
    String pollOption4;

    public String getPollOption1() {
        return pollOption1;
    }

    public void setPollOption1(String pollOption1) {
        this.pollOption1 = pollOption1;
    }

    public String getPollOption2() {
        return pollOption2;
    }

    public void setPollOption2(String pollOption2) {
        this.pollOption2 = pollOption2;
    }

    public String getPollOption3() {
        return pollOption3;
    }

    public void setPollOption3(String pollOption3) {
        this.pollOption3 = pollOption3;
    }

    public String getPollOption4() {
        return pollOption4;
    }

    public void setPollOption4(String pollOption4) {
        this.pollOption4 = pollOption4;
    }

    public String getPollQuestion() {
        return pollQuestion;
    }

    public void setPollQuestion(String pollQuestion) {
        this.pollQuestion = pollQuestion;
    }
    
}
