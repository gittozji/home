package me.imyu.home.auth.authc.impl;

import me.imyu.home.auth.authc.AuthcException;
import me.imyu.home.auth.token.Token;
import me.imyu.home.auth.token.jwt.JWT;
import me.imyu.home.auth.token.jwt.StrJWT;

/**
 * 用于认证{@link me.imyu.home.auth.token.jwt.StrJWT}
 *
 * Created by imyu on 2018-01-04.
 */
public class StrJWTAuthenticator extends AbstractAuthenticator {
    @Override
    protected JWT doAuthenticate(Token token) throws AuthcException {
        isSupport(token);

        return null;
    }

    private void isSupport(Token token) {
        if (!(token instanceof StrJWT)) {
            throw new AuthcException("不支持的 token 类型，请传入StrJWT类型");
        }
    }
}
