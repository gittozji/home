package me.imyu.home.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 用户控制器
 *
 * Created by imyu on 2017-12-24.
 */
@Controller
public class UserController {
    private final static Logger LOGGER = LogManager.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @RequestMapping(path = "/user/view")
    @RequiresPermissions("user:view")
    public ModelAndView view() {
        LOGGER.info("有user:view权限的用户操作");
        return new ModelAndView("user/list");
    }

    @RequestMapping(path = "/user/edit")
    @RequiresPermissions("user:edit")
    public ModelAndView edit() {
        LOGGER.info("有user:edit权限的用户操作");
        return new ModelAndView("user/list");
    }

    @RequestMapping(path = "/user/leader")
    @RequiresRoles("leader")
    public ModelAndView leader() {
        LOGGER.info("领导身份的用户操作");
        return new ModelAndView("user/list");
    }

    @RequestMapping(path = "/user/customer")
    @RequiresRoles("customer")
    public ModelAndView customer() {
        LOGGER.info("顾客身份的用户操作");
        return new ModelAndView("user/list");
    }
}
