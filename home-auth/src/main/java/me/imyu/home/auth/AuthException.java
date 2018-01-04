package me.imyu.home.auth;

/**
 * 鉴权异常
 * Created by imyu on 2018-01-03.
 */
public class AuthException extends RuntimeException {
    public AuthException(String message) {
        super(message);
    }
}
