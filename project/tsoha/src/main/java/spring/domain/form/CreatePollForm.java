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
 */
public class CreatePollForm {
    @NotNull
    @NotEmpty
    String pollQuestion;
    @NotNull
    AutoPopulatingList<String> pollOptions;

    public AutoPopulatingList<String> getPollOptions() {
        return pollOptions;
    }

    public void setPollOptions(AutoPopulatingList<String> pollOptions) {
        this.pollOptions = pollOptions;
    }

    public String getPollQuestion() {
        return pollQuestion;
    }

    public void setPollQuestion(String pollQuestion) {
        this.pollQuestion = pollQuestion;
    }
    
}
