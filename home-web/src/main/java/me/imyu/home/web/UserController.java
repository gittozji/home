package me.imyu.home.web;

import me.imyu.home.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by imyu on 2017-12-06.
 */
@Controller
public class UserController {
    private final static Logger LOGGER = LogManager.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @RequestMapping(path = "/user/list")
    public ModelAndView list() {
        System.out.println(userService.queryAll());
        return new ModelAndView("user/list");
    }
}
