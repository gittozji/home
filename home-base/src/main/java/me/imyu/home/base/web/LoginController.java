package me.imyu.home.base.web;

import me.imyu.home.base.model.dto.ResultBean;
import me.imyu.home.base.service.UserService;
import me.imyu.home.base.util.SAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by imyu on 2018-02-13.
 */
@RestController
public class LoginController {
    private static final int ERROR_COUNT = 5;
    @Autowired
    UserService userService;
    @RequestMapping("/base/login")
    public ResultBean login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        SAssert.hasLength(username, "用户名不能为空！");
        SAssert.hasLength(password, "密码不能为空！");

        userService.login(username, password, request, response);
        return new ResultBean();
    }
}
