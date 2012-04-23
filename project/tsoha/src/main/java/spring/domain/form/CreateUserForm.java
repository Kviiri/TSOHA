/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.domain.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.AssertTrue;

/**
 *
 * @author kviiri
 */
public class CreateUserForm {

    @NotNull
    private String name;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
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
    
    @AssertTrue(message="Annoit varmistuskenttään väärän salasanan.")
    private boolean checkPassword() {
        return password.equals(confirmPassword);
    }
}
