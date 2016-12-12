package org.academiadecodigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;

/**
 * Created by codecadet on 12/12/16.
 */
@Controller
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String sayHello(Model model) {

        model.addAttribute("greeting", "Hello World");

        return "hello";
    }
}
