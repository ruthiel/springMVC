package org.academiadecodigo.controller;

import org.academiadecodigo.auth.Authenticator;
import org.academiadecodigo.model.User;
import org.academiadecodigo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


/**
 * Created by codecadet on 12/12/16.
 */
@Controller
@SessionAttributes("loginUser")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private Authenticator authenticator;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ModelAndView showLogin() {

        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", new User());

        userService.addUser(new User("Ruthiel", "12345", "ruthiel.trevisan@gmail.com"));

        return modelAndView;

    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String doLogin(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if( bindingResult.hasErrors()) {
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
