package me.imyu.home.auth.authc;

import me.imyu.home.auth.token.Token;
import me.imyu.home.auth.token.jwt.JWT;

/**
 * Created by imyu on 2018-01-04.
 */
public interface AuthcListener {
    void onSuccess(Token token, JWT jwt);
    void onFailure(Token token, AuthcException ae);
}
