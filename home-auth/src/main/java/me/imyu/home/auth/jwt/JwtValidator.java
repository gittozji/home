package me.imyu.home.auth.jwt;

import me.imyu.home.auth.AuthException;

import java.util.Map;

/**
 * Created by imyu on 2018-01-31.
 */
public class JwtValidator {
    public static Jwt validate(String src) throws AuthException{
        int index = src.lastIndexOf(".");
        String headerAndPayload = src.substring(0, index);
        String scret = src.substring(index + 1, src.length());
        if (!Crypto.sign(headerAndPayload).equals(scret)) {
            throw new AuthException(AuthConstants.ILLEGAL_TOKEN);
        }

        Jwt jwt = JwtParser.parseJWT(src);
        Map header = jwt.getHeader();
        Long expireAt = (Long) header.get("expireAt");
        if (expireAt < System.currentTimeMillis()) {
            throw new AuthException(AuthConstants.EXPIRE_TOKEN);
        }
        return jwt;
    }
}
