package me.imyu.home.base.service;

/**
 * 基础服务异常
 * Created by imyu on 2018-01-03.
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
