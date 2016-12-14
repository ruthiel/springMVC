package org.academiadecodigo.controller;

import org.academiadecodigo.auth.Authenticator;
import org.academiadecodigo.model.User;
import org.academiadecodigo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by codecadet on 13/12/16.
 */
@Controller
@SessionAttributes("loggedUser")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Authenticator authenticator;

    @RequestMapping(method = RequestMethod.POST, value = "/user/add")
    public String addUser(Model model, @ModelAttribute User user, RedirectAttributes redirect) {

        userService.addUser(user);
        redirect.addFlashAttribute("addMessage", "Added user " + user.getUsername() + " successfully!");
        return "redirect:/users";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/remove/{username}")
    public String removeUser(Model model, @PathVariable String username) {

        userService.removeUser(username);
        return "redirect:/users";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public String listUsers(Model model) {
        model.addAttribute("userMap", userService.findAll());
        model.addAttribute("user", new User());
        return "main";
    }



}
