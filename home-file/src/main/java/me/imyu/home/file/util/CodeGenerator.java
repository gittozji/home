package me.imyu.home.file.util;

import java.util.UUID;

/**
 * Created by imyu on 2018-04-02.
 */
public class CodeGenerator {
    public static String get() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
