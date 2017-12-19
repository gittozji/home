package me.imyu.home.service;

import me.imyu.home.model.User;

import java.util.List;

/**
 * 用户信息服务
 * Created by imyu on 2017-12-06.
 */
public interface UserService {
    User findByUsername(String username);
}
