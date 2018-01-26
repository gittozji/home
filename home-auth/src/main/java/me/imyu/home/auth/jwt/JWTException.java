package me.imyu.home.auth.jwt;

import me.imyu.home.auth.AuthException;

/**
 * Created by imyu on 2018-01-26.
 */
public class JWTException extends AuthException{
    public JWTException(String message) {
        super(message);
    }
}
