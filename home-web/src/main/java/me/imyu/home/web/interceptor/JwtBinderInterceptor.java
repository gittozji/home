package me.imyu.home.web.interceptor;

import me.imyu.home.auth.jwt.Jwt;
import me.imyu.home.auth.jwt.JwtBinder;
import me.imyu.home.auth.jwt.JwtParser;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by imyu on 2018-02-13.
 */
public class JwtBinderInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = "";

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                token = cookie.getValue();
                break;
            }
        }

        if (token.isEmpty()) {
            JwtBinder.bind(null);
        } else {
            Jwt jwt = JwtParser.parseJWT(token);
            JwtBinder.bind(jwt);
        }

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        JwtBinder.unbind();
    }
}
