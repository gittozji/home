package me.imyu.home.auth.jwt;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.hash.Sha256Hash;

import java.security.Key;
import java.util.Map;

/**
 * Created by imyu on 2018-01-26.
 */
public class DefaultJWTManager extends AbstractJWTManager {
    private static AesCipherService aesCipherService = new AesCipherService();
    private static Key key;

    static {
        aesCipherService.setKeySize(128);
        key = aesCipherService.generateNewKey();
    }

    @Override
    protected JWT doGetJWT(String src) throws JWTException {
        return parseJWT(src);
    }

    @Override
    protected String doGetStr(Map payload) throws JWTException {
        return parseStr(new JWT(null, null, null));
    }

    public JWT parseJWT(String src) throws JWTException {
        String[] arr = src.split("\\.");
        String hs = decrypt(arr[0]);
        String ps = decrypt(arr[1]);
        String ss = arr[2];
        Map header = JSON.parseObject(hs);
        Map payload = JSON.parseObject(ps);
        String secret = ss;
        return new JWT(header, payload, secret);
    }

    public String parseStr(JWT jwt) throws JWTException {
        String hs = encrypt(JSON.toJSONString(jwt.getHeader()));
        String ps = encrypt(JSON.toJSONString(jwt.getPayload()));
        String hps = hs + "." + ps;
        String target = hps + "." + sign(hps);
        return target;
    }

    private String encrypt(String src) {
        return aesCipherService.encrypt(src.getBytes(), key.getEncoded()).toBase64();
    }

    private String decrypt(String src) {
        return new String(aesCipherService.decrypt(org.apache.shiro.codec.Base64.decode(src), key.getEncoded()).getBytes());
    }

    private String sign(String src) {
        return new Sha256Hash(src).toString();
    }
}
