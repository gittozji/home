package me.imyu.home.base.service;

import me.imyu.home.base.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户服务
 * Created by imyu on 2017/12/24.
 */
public interface UserService {
    User findByUsername(String username);

    void login(String username, String password, HttpServletRequest request, HttpServletResponse response);
}
