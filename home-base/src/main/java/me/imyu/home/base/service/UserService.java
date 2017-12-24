package me.imyu.home.base.service;

import me.imyu.home.base.model.User;

/**
 * 用户服务
 * Created by imyu on 2017/12/24.
 */
public interface UserService {
    User findByUsername(String username);
}
