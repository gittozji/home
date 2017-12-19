package me.imyu.home.exception;

/**
 * 业务异常
 * Created by imyu on 2017-12-19.
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
