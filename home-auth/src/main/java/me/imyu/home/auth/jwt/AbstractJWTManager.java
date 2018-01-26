package me.imyu.home.auth.jwt;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * Created by imyu on 2018-01-26.
 */
public abstract class AbstractJWTManager implements JWTManager {


    @Override
    public JWT getJWT(String src) throws JWTException {
        return doGetJWT(src);
    }

    @Override
    public String getStr(Map payload) {
        return doGetStr(payload);
    }

    protected abstract JWT doGetJWT(String src) throws JWTException;
    protected abstract String doGetStr(Map payload) throws JWTException;
}
