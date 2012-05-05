/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.domain.form;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.AutoPopulatingList;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 *
 * @author kviiri
 */
public class CreatePollForm {
    @NotNull
    @Size(min=1, max=200, message="Kysymyksen täytyy olla 1-200 merkkiä")
    @javax.validation.constraints.Pattern(regexp="[a-zåäöA-ZÅÄÖ0-9\\s!?.,]+", message="Kysymys saa sisältää vain kirjaimia ja numeroita.")
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
    
    public void validatePollOptions(BindingResult result) {
        Pattern p = Pattern.compile("[a-zåäöA-ZÅÄÖ0-9\\s!?.,]+");
        for(String s : pollOptions) {
            Matcher m = p.matcher(s);
            if(!m.matches()) {
                result.addError(new FieldError("pollForm", "pollQuestion", "Kysymys ja vastausvaihtoehdot saavat sisältää vain kirjaimia,"
                        + "numeroita, välilyönnin ja välimerkkejä piste, pilkku, huutomerkki ja kysymysmerkki."));
                return;
            }
        }
    }
    
}
