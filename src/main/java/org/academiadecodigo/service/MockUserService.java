package org.academiadecodigo.service;

import org.academiadecodigo.model.User;

/**
 * Created by codecadet on 12/12/16.
 */
public class MockUserService implements UserService {
    @Override
    public void addUser(String username) {

    }

    @Override
    public void removeUser(String username) {

    }

    @Override
    public User findUser(String username) {
        return null;
    }
}
