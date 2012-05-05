/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.domain.form;

import java.util.regex.Matcher;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 *
 * @author kviiri
 */
public class CreateUserForm {
    
    @NotNull(message="Nimi ei saa olla tyhjä.")
    @Pattern(regexp="\\w+", message="Nimessä saa olla vain numeroita ja kirjaimia.")
    @Size(min=5, max=30, message="Nimen täytyy olla 5-30 merkkiä.")
    private String name;
    
    @NotNull(message="Käyttäjänimi ei saa olla tyhjä.")
    @Pattern(regexp="\\w+", message="Käyttäjätunnuksessa saa olla vain numeroita ja kirjaimia.")
    @Size(min=5, max=16, message="Käyttäjätunnuksessa täytyy olla 5-16 merkkiä.")
    private String username;
    
    @NotNull(message="Salasana ei saa olla tyhjä.")
    @Pattern(regexp="\\w+", message="Salasanassa saa olla vain numeroita ja kirjaimia.")
    @Size(min=8, max=16, message="Salasanassa täytyy olla 8-16 merkkiä.")
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
    
    
    
    public void validatePasswordEqualsConfirmedPassword(BindingResult result) {
        if(!password.equals(confirmPassword)) {
            result.addError(new FieldError("userForm", "confirmPassword", "Salasanasi ja varmistustekstisi eivät täsmänneet!"));
        }
    }
    
}
