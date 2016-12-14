package org.academiadecodigo.model;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * Created by codecadet on 12/12/16.
 */
public class User {


    @NotNull(message = "username is mandatory")
    @NotBlank(message = "username is mandatory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "username has invalid characters")
    private String username;

    @NotNull
    @Size(min = 5, max = 8)
    private String password;

    @Email
    private String email;


    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return username;
    }
}
