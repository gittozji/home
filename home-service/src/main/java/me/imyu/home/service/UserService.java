package me.imyu.home.service;

import me.imyu.home.model.User;

import java.util.List;

/**
 * Created by imyu on 2017-12-06.
 */
public interface UserService {
    public List<User> queryAll();

    public User findByUsername(String username);
}
