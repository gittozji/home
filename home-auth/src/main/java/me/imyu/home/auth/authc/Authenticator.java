package me.imyu.home.auth.authc;

import me.imyu.home.auth.AuthException;
import me.imyu.home.auth.token.jwt.JWT;
import me.imyu.home.auth.token.Token;

/**
 * 认证
 *
 * Created by imyu on 2018-01-03.
 */
public interface Authenticator {
    JWT authenticate (Token token) throws AuthException;
}
