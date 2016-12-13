package org.academiadecodigo.service;

import org.academiadecodigo.model.User;

/**
 * Created by codecadet on 12/12/16.
 */
public interface UserService {

    void addUser(String username);
    void removeUser(String username);
    User findUser(String username);
}
