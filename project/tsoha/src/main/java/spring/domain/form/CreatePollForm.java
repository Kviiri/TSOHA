/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.domain.form;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.AutoPopulatingList;

/**
 *
 * @author kviiri
 */
public class CreatePollForm {
    @NotNull
    @Size(min=1, max=200, message="Kysymyksen täytyy olla 1-200 merkkiä")
    @Pattern(regexp="[a-zåäöA-ZÅÄÖ0-9]+", message="Kysymys saa sisältää vain kirjaimia ja numeroita.")
    String pollQuestion;
    @NotNull
    List<String> pollOptions;

    public List<String> getPollOptions() {
        return pollOptions;
    }

    public void setPollOptions(List<String> pollOptions) {
        this.pollOptions = pollOptions;
    }

    public String getPollQuestion() {
        return pollQuestion;
    }

    public void setPollQuestion(String pollQuestion) {
        this.pollQuestion = pollQuestion;
    }
    
}
