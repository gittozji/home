package me.imyu.home.base.service.impl;

import me.imyu.home.auth.jwt.Crypto;
import me.imyu.home.auth.jwt.Jwt;
import me.imyu.home.auth.jwt.JwtParser;
import me.imyu.home.base.dao.UserDao;
import me.imyu.home.base.model.User;
import me.imyu.home.base.service.ServiceException;
import me.imyu.home.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by imyu on 2017/12/24.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User findByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public void login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        User user = userDao.selectByUsername(username);
        if (user == null) {
            throw new ServiceException("用户名或密码错误！");
        }

        if (!Crypto.sign(password).equals(user.getPassword())) {
            user.setErrorCount(user.getErrorCount() + 1);
            userDao.updateErrorCount(user);
            throw new ServiceException("用户名或密码错误！");
        }

        if (user.getErrorCount() > 5) {
            throw new ServiceException("用户已被锁定！");
        }

        user.setErrorCount(0);
        userDao.updateErrorCount(user);
        user.setPassword(null);

        Map header = new HashMap();
        header.put("expireAt", System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000); // 两天的过期时间
        Map payload = new HashMap();
        payload.put("user", user);
        Jwt jwt = new Jwt(header, payload, null);
        String token = JwtParser.parseStr(jwt);

        Cookie cookie = new Cookie("token",token);
        cookie.setMaxAge(2 * 24 * 60 * 60);// 两天的过期时间
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
