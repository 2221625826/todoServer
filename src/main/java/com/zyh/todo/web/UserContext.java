package com.zyh.todo.web;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author zhangyiheng03
 * @since 2022/6/24 15:38
 */
public class UserContext {
    private static ThreadLocal<String> user;

    public static void remove() {
        user.remove();
    }

    public static void setUser(String user) {
        UserContext.user.set(user);
    }
}