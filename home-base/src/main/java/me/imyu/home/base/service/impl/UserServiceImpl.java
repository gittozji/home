package me.imyu.home.base.service.impl;

import me.imyu.home.base.dao.UserDao;
import me.imyu.home.base.model.User;
import me.imyu.home.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by imyu on 2017/12/24.
 */
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User findByUsername(String username) {
        return userDao.selectByUsername(username);
    }
}
