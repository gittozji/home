package me.imyu.home.base.util;

import me.imyu.home.base.model.User;
import org.springframework.util.Assert;

/**
 * 用户助手
 * Created by imyu on 2018-04-04.
 */
public class UserBinder {
    private static final ThreadLocal<User> userLocal = new ThreadLocal<User>();

    public static void bind(User user) {
        userLocal.set(user);
    }

    public static void unbind() {
        userLocal.remove();
    }

    public static User get() {
        User user = userLocal.get();

        Assert.notNull(user, "Please use get after bind !");

        return user;
    }
}
