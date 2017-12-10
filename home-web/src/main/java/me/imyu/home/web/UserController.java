package me.imyu.home.web;

import me.imyu.home.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 用户控制器
 *
 * Created by imyu on 2017-12-06.
 */
@Controller
public class UserController {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @RequestMapping(path = "/user/list")
    public ModelAndView list() {
        System.out.println(userService.queryAll());
        return new ModelAndView("user/list");
    }
}
