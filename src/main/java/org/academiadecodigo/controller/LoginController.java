package org.academiadecodigo.controller;

import org.academiadecodigo.auth.Authenticator;
import org.academiadecodigo.model.User;
import org.academiadecodigo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by codecadet on 12/12/16.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    private Authenticator authenticator;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String doLogin(Model model, @ModelAttribute("user") User user) {

        if (user.getUsername() == null || user.getUsername().isEmpty() ||
                user.getPassword() == null || user.getPassword().isEmpty()) {

            return "login";
        }

        if (authenticator.authenticate(user.getUsername(), user.getPassword())) {
            model.addAttribute("greeting", "Welcome");
            return "main";

        } else {
            model.addAttribute("error", "Authentication Failure");
            return "login";
        }
    }
}
