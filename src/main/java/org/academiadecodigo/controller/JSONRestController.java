package org.academiadecodigo.controller;

import org.academiadecodigo.auth.Authenticator;
import org.academiadecodigo.model.User;
import org.academiadecodigo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.condition.MediaTypeExpression;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * Created by codecadet on 15/12/16.
 */
@RestController
public class JSONRestController {

    @Autowired
    private Authenticator authenticator;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addUser(@RequestBody User user) {

        userService.addUser(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/users/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> removeUser(@PathVariable String username) {

        userService.removeUser(username);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection> listUsers() {

        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);

    }

//    @RequestMapping(method = RequestMethod.GET, value = "/users")
//    public ResponseEntity<User> logout() {
//
//    }


}
