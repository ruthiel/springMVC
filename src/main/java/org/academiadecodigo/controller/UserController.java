package org.academiadecodigo.controller;

import org.academiadecodigo.auth.Authenticator;
import org.academiadecodigo.model.User;
import org.academiadecodigo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
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

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public String addUser(Model model, @ModelAttribute User user, RedirectAttributes redirect) {

        userService.addUser(user);
        redirect.addFlashAttribute("addMessage", "Added user " + user.getUsername() + " successfully!");
        return "redirect:/users";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/remove/{username}")
    public String removeUser(Model model, @PathVariable String username, RedirectAttributes redirect) {

        userService.removeUser(username);
        redirect.addFlashAttribute("removeMessage", username + " was deleted successfully!");
        return "redirect:/users";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public String listUsers(Model model) {
        model.addAttribute("loggedUser");
        model.addAttribute("userMap", userService.findAll());
        model.addAttribute("user", new User());

        if(model.asMap().get("loggedUser") == null) {
            return "login";
        }
        return "main";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }



}
