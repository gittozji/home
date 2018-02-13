package me.imyu.home.auth.jwt;

import java.util.Map;

/**
 * Created by imyu on 2018-01-26.
 */
public class Jwt {
    Map header;
    Map payload;
    String secret;

    public Jwt() {
    }

    public Jwt(Map header, Map payload, String secret) {
        this.header = header;
        this.payload = payload;
        this.secret = secret;
    }

    public Map getHeader() {
        return header;
    }

    public void setHeader(Map header) {
        this.header = header;
    }

    public Map getPayload() {
        return payload;
    }

    public void setPayload(Map payload) {
        this.payload = payload;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
