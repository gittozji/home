package me.imyu.home.service.impl;

import me.imyu.home.dao.UserDao;
import me.imyu.home.model.User;
import me.imyu.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by imyu on 2017-12-06.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> queryAll() {
        return userDao.selectAll();
    }

    @Override
    public User findByUsername(String username) {
        return userDao.selectByUsername(username);
    }
}
