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
@SessionAttributes("loggedUser")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private Authenticator authenticator;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ModelAndView showLogin() {


        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", new User());

        userService.addUser(new User("Ruthiel", "admin", "ruthiel.trevisan@gmail.com"));
        userService.addUser(new User("Eurico", "admin", "eurico@sapo.pt"));
        userService.addUser(new User("Rafa", "admin", "rafa@sapo.pt"));
        userService.addUser(new User("Mariana", "admin", "mariana@sapo.pt"));
        userService.addUser(new User("Filipe", "admin", "filipe@sapo.pt"));

        return modelAndView;

    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String doLogin(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if( bindingResult.hasErrors()) {
            return "login";
        }

        if (authenticator.authenticate(user.getUsername(), user.getPassword())) {
//            model.addAttribute("greeting", "Welcome");
            model.addAttribute("userMap", userService.findAll());
            model.addAttribute("loggedUser", user);
            return "redirect:/users";

        } else {
            model.addAttribute("error", "Authentication Failure");
            return "login";
        }

    }
}
