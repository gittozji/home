package me.imyu.home.auth.jwt;

import java.util.Map;

/**
 * Created by imyu on 2018-01-26.
 */
public interface JWTManager {
    String getStr(Map payload);
    JWT getJWT(String src) throws JWTException;
}
