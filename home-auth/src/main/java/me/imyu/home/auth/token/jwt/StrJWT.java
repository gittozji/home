package me.imyu.home.auth.token.jwt;

import me.imyu.home.auth.token.Token;

/**
 * String type fo JSON WEN TOKEN
 *
 * Created by imyu on 2018-01-04.
 */
public class StrJWT implements Token {
    String src;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
