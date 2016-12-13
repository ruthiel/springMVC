package org.academiadecodigo.auth;

import org.academiadecodigo.model.User;
import org.academiadecodigo.service.UserService;

/**
 * Created by codecadet on 12/12/16.
 */
public class Authenticator {

    private UserService userService;

    public boolean authenticate(String username, String password) {
        User user = userService.findByName(username);
        return user != null && user.getPassword().equals(password);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
