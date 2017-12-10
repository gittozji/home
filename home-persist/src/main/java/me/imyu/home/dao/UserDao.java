package me.imyu.home.dao;

import me.imyu.home.model.User;

import java.util.List;

/**
 * Created by imyu on 2017-12-06.
 */
public interface UserDao {
    List<User> selectAll();
    User selectByUsername(String username);
}
