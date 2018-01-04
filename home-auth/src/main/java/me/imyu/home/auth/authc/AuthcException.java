package me.imyu.home.auth.authc;

import me.imyu.home.auth.AuthException;

/**
 * 认证异常
 *
 * Created by imyu on 2018-01-04.
 */
public class AuthcException extends AuthException {
    public AuthcException(String message) {
        super(message);
    }
}
