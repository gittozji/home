package me.imyu.home.auth.jwt;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.codec.Base64;

import java.util.Map;

/**
 * Created by imyu on 2018-01-31.
 */
public class JwtParser {
    public static Jwt parseJWT(String src) {
        String[] arr = src.split("\\.");
        String hs = Base64.decodeToString(arr[0]);
        String ps = Crypto.decrypt(arr[1]);
        String ss = arr[2];
        Map header = JSON.parseObject(hs);
        Map payload = JSON.parseObject(ps);
        String secret = ss;
        return new Jwt(header, payload, secret);
    }

    public static String parseStr(Jwt jwt) {
        String header = new String(Base64.encode(JSON.toJSONString(jwt.getHeader()).getBytes()));
        String payload = Crypto.encrypt(JSON.toJSONString(jwt.getPayload()));
        String headerAndPayload = header + "." + payload;
        String secret = jwt.getSecret() == null ? Crypto.sign(headerAndPayload) : jwt.getSecret();
        return headerAndPayload + "." + secret;
    }
}
