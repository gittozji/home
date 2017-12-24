package me.imyu.home.base.dao;

import me.imyu.home.base.model.User;

/**
 * 用户DAO
 * Created by imyu on 2017/12/24.
 */
public interface UserDao {
    User selectByUsername(String username);
}