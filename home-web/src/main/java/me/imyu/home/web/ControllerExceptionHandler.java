package me.imyu.home.web;

import me.imyu.home.model.dto.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制层异常处理器
 *
 * Created by imyu on 2017-12-19.
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    @ExceptionHandler
    public ResultBean handleException(Exception e) {
        LOGGER.error("控制层发生异常", e);
        return new ResultBean(e);
    }
}
