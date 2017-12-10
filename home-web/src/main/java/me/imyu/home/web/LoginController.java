package me.imyu.home.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录退出控制器
 *
 * Created by imyu on 2017/12/9.
 */
@Controller
public class LoginController {
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    /**
     * 登录页面请求
     *
     * @return
     */
    @RequestMapping(path = "/login")
    public ModelAndView list() {
        return new ModelAndView("anon/login");
    }

    /**
     * 登录动作
     *
     * @return
     */
    @RequestMapping(value = "/anon/dologin")
    public ModelAndView doLogin(HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) throws Exception {
        String viewName = "redirect:/welcome.html";
        String errorInfo = null;
        try {
            UsernamePasswordToken usernamePasswordUsertypeToken = new UsernamePasswordToken(
                    httpServletRequest.getParameter("username"), httpServletRequest.getParameter("password"));
            usernamePasswordUsertypeToken.setRememberMe(true);
            Subject subject = SecurityUtils.getSubject();
            // 先退出之前可能在线的用户
            subject.logout();
            // 用户登录
            subject.login(usernamePasswordUsertypeToken);
        } catch (UnknownAccountException e) {
            errorInfo = "用户名或密码不正确";
        } catch (IncorrectCredentialsException e) {
            errorInfo = "用户名或密码不正确";
        }
        if (errorInfo != null) {
            redirectAttributes.addFlashAttribute("errorInfo", errorInfo);
            viewName = "redirect:/login.html";
        }
        return new ModelAndView(viewName);
    }
}
