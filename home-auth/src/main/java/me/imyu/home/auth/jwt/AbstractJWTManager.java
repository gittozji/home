package me.imyu.home.auth.jwt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by imyu on 2018-01-26.
 */
public abstract class AbstractJWTManager implements JWTManager {
    public JWT parseJWT(String src) throws JWTException {
        String[] arr = src.split(".");
        String hs = arr[0];
        String ps = arr[1];
        String ss = arr[2];
        Map header = JSON.parseObject(hs);
        Map payload = JSON.parseObject(ps);
        String secret = ss;
        return new JWT(header, payload, secret);
    }

    public String parseStr(JWT jwt) throws JWTException {
        String hs = JSON.toJSONString(jwt.getHeader());
        String ps = JSON.toJSONString(jwt.getPayload());
        String hps = hs + "." + ps;
        String target = hps + "." + sign(hps);
        return target;
    }

    @Override
    public JWT getJWT(String src) throws JWTException {
        return doGetJWT(src);
    }

    protected abstract JWT doGetJWT(String src) throws JWTException;

    protected abstract String sign(String src);
}
