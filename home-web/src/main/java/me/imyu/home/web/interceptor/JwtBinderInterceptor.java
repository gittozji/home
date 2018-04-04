package me.imyu.home.web.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import me.imyu.home.auth.AuthException;
import me.imyu.home.auth.jwt.Jwt;
import me.imyu.home.auth.jwt.JwtBinder;
import me.imyu.home.auth.jwt.JwtValidator;
import me.imyu.home.base.model.User;
import me.imyu.home.base.util.UserBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.HashSet;

/**
 * 暂且充当第一层身份认证
 * Created by imyu on 2018-02-13.
 */
public class JwtBinderInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtBinderInterceptor.class);
    private static final String LOGIN_URI = "/base/pages/login.html";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!isCheck(request)) {
            return super.preHandle(request, response, handler);
        }

        if (!checkJwt(request)) {
            response.sendRedirect(request.getContextPath() + LOGIN_URI);
            return false;
        }

        return super.preHandle(request, response, handler);
    }

    private boolean checkJwt(HttpServletRequest request) {
        String token = null;

        // 获取token
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        if (StringUtils.isEmpty(token)){
            LOGGER.error("没有token");
            return false;
        }

        // 校验token
        Jwt jwt;
        try {
            jwt = JwtValidator.validate(token);
        } catch (AuthException e) {
            LOGGER.error(String.format("%s,%s", e.getMessage(), token));
            return false;
        }

        JwtBinder.bind(jwt);
        UserBinder.bind(JSONObject.toJavaObject((JSON) jwt.getPayload().get("user"), User.class));
        return true;
    }

    private boolean isCheck(HttpServletRequest request) {
        Collection<String> collection = new HashSet();
        collection.add(LOGIN_URI);
        collection.add("/base/login");
        String uri = request.getServletPath();
        for (String item : collection) {
            if (uri.equals(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        JwtBinder.unbind();
    }


}
