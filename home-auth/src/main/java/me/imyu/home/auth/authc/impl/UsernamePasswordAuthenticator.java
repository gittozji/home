package me.imyu.home.auth.authc.impl;

import me.imyu.home.auth.authc.AuthcException;
import me.imyu.home.auth.token.Token;
import me.imyu.home.auth.token.UsernamePasswordToken;
import me.imyu.home.auth.token.jwt.JWT;

/**
 * 用于认证{@link me.imyu.home.auth.token.UsernamePasswordToken}
 *
 * Created by imyu on 2018-01-04.
 */
public class UsernamePasswordAuthenticator extends AbstractAuthenticator {
    @Override
    protected JWT doAuthenticate(Token token) throws AuthcException {
        isSupport(token);
        checkToken(token);
        return null;
    }

    private void checkToken(Token token) {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        String password = usernamePasswordToken.getPassword();
        if (false) {
            throw new AuthcException("用户名或密码错误");
        }
    }

    private void isSupport(Token token) {
        if (!(token instanceof UsernamePasswordToken)) {
            throw new AuthcException("不支持的 token 类型，请传入UsernamePasswordToken类型");
        }
    }

}
