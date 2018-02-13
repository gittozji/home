package me.imyu.home.web.exception;

import me.imyu.home.base.model.dto.ResultBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created by imyu on 2018-02-13.
 */
@Aspect
@Component
public class ExceptionHandler implements Ordered{
    @Around("execution(public me.imyu.home.base.model.dto.ResultBean *(..))")
    public Object process(ProceedingJoinPoint pj) {
        ResultBean<?> result;
        try {
            result = (ResultBean<?>) pj.proceed();
        } catch (Throwable  t) {
            result = new ResultBean(t);
        }
        return result;
    }
    @Override
    public int getOrder() {
        return 0;
    }
}
