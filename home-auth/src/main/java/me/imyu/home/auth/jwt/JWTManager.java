package me.imyu.home.auth.jwt;

/**
 * Created by imyu on 2018-01-26.
 */
public interface JWTManager {
    JWT getJWT(String src) throws JWTException;
}
