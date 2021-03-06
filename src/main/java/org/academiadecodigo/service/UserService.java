package org.academiadecodigo.service;

import org.academiadecodigo.model.User;

import java.util.List;

/**
 * Created by codecadet on 12/12/16.
 */
public interface UserService {


    void addUser(User user);

    void removeUser(String username);

    User findByName(String username);

    List<User> findAll();

    User getUser(String username);

    long count();
}
