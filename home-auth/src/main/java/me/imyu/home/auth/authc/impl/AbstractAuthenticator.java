package me.imyu.home.auth.authc.impl;

import me.imyu.home.auth.authc.AuthcException;
import me.imyu.home.auth.authc.AuthcListener;
import me.imyu.home.auth.authc.Authenticator;
import me.imyu.home.auth.token.Token;
import me.imyu.home.auth.token.jwt.JWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 抽象认证器
 *
 * Created by imyu on 2018-01-04.
 */
public abstract class AbstractAuthenticator implements Authenticator {
    private final static Logger LOGGER = LoggerFactory.getLogger(AbstractAuthenticator.class);
    private Collection<AuthcListener> listeners;

    public AbstractAuthenticator() {
        this.listeners = new ArrayList<AuthcListener>();
    }

    public Collection<AuthcListener> getListeners() {
        return listeners;
    }

    public void setListeners(Collection<AuthcListener> listeners) {
        if (listeners == null) {
            this.listeners = new ArrayList<AuthcListener>();
        } else {
            this.listeners = listeners;
        }
    }

    protected void notifySuccess(Token token, JWT jwt) {
        for (AuthcListener listener : this.listeners) {
            listener.onSuccess(token, jwt);
        }
    }

    protected void notifyFailure(Token token, AuthcException ae) {
        for (AuthcListener listener : this.listeners) {
            listener.onFailure(token, ae);
        }
    }

    @Override
    public JWT authenticate(Token token) throws AuthcException {

        if (token == null) {
            throw new IllegalArgumentException("Method argument (Token token) cannot be null.");
        }

        JWT jwt = null;
        try {
            jwt = doAuthenticate(token);
            if (null == jwt) {
                throw new AuthcException("认证失败");
            }
        } catch (Throwable t) {
            AuthcException ae = null;
            if (t instanceof AuthcException) {
                ae = (AuthcException) t;
            }

            notifyFailure(token, ae);

            throw ae;
        }

        notifySuccess(token, jwt);

        return jwt;
    }

    protected abstract JWT doAuthenticate(Token token) throws AuthcException;
}
