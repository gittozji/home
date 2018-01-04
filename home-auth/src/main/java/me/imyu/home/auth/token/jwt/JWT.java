package me.imyu.home.auth.token.jwt;

import me.imyu.home.auth.token.Token;

/**
 * JSON WEB TOKEN
 *
 * Created by imyu on 2018-01-03.
 */
public class JWT implements Token {
    Header header;
    Payload payload;
    String secret;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
