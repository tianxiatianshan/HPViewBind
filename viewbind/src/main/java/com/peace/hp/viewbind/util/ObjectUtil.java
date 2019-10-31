package com.peace.hp.viewbind.util;

/**
 * @Author: HePing
 * @Date: 2019/10/31
 * @Description:
 */
public class ObjectUtil {
    public static <T> void requireNonNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
    }

    public static <T> void requireNonNull(T obj, String message) {
        if (obj == null) {
            throw new NullPointerException(message);
        }
    }
}
