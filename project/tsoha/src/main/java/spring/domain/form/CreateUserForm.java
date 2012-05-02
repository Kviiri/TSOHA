/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.domain.form;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.AssertTrue;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 *
 * @author kviiri
 */
public class CreateUserForm {

    public static Pattern alphaNumericValidationPattern = Pattern.compile("[a-zåäöA-ZÅÄÖ0-9]*");
    
    private String name;
    private String username;
    private String password;
    private String confirmPassword;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    
    public BindingResult validateForm(BindingResult result) {
        validatePasswordEqualsConfirmedPassword(result);
        validateName(result);
        validateUserName(result);
        validatePassword(result);
        
        return result;
    }
    
    private BindingResult validatePasswordEqualsConfirmedPassword(BindingResult result) {
        if(!password.equals(confirmPassword)) {
            result.addError(new ObjectError("password", "Salasanasi ja varmistustekstisi eivät täsmänneet!"));
        }
        return result;
    }
    
    private BindingResult validateName(BindingResult result) {
        if(name.length() < 3 || name.length() > 30) {
            result.addError(new ObjectError("name", "Nimessä täytyy olla 3-30 merkkiä."));
        }
        Matcher m = alphaNumericValidationPattern.matcher(name);
        if(!m.matches()) {
            result.addError(new ObjectError("name", "Nimessä saa olla vain kirjaimia ja numeroita."));
        }
        return result;
    }
    
    private BindingResult validateUserName(BindingResult result) {
        if(name.length() < 3 || name.length() > 30) {
            result.addError(new ObjectError("username", "Käyttäjätunnuksessa täytyy olla 3-30 merkkiä."));
        }
        Matcher m = alphaNumericValidationPattern.matcher(name);
        if(!m.matches()) {
            result.addError(new ObjectError("username", "Käyttäjätunnuksessa saa olla vain kirjaimia ja numeroita."));
        }
        return result;
    }
    
    private BindingResult validatePassword(BindingResult result) {
        if(password.length() < 5 || password.length() > 30) {
            result.addError(new ObjectError("password", "Salasanassa täytyy olla 5-30 merkkiä."));
        }
        Matcher m = alphaNumericValidationPattern.matcher(name);
        if(!m.matches()) {
            result.addError(new ObjectError("password", "Salasanassa saa olla vain kirjaimia ja numeroita."));
        }
        return result;
    }
}
