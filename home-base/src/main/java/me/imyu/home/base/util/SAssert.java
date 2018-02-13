package me.imyu.home.base.util;

import me.imyu.home.base.service.ServiceException;
import org.springframework.util.Assert;

/**
 * Created by imyu on 2018-02-13.
 */
public class SAssert {
    public static void hasLength(String src, String message) {
        try{
            Assert.hasLength(src, message);
        } catch (Exception e) {
            throw new ServiceException(message);
        }
    }
}
