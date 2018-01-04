package me.imyu.home.auth.util;

/**
 * JWT解析转换工具
 *
 * Created by imyu on 2018-01-04.
 */
public class JWTUtils {
    public static boolean check(String src, String salt) {
        if (null == src || src.isEmpty()) {
            return false;
        }

        String hp = src.substring(0, src.lastIndexOf("."));
        String se = src.substring(src.lastIndexOf(".") + 1, src.length());
        if (se.equals(SHA256Utils.sha256(hp, salt))) {
            return true;
        }

        return false;
    }
}
