package com.zyh.todo.web;

/**
 * @author zhangyiheng03
 * @since 2022/6/24 15:38
 */
public class UserContext {
    private static ThreadLocal<Integer> userId;

    public static void remove() {
        userId.remove();
    }

    public static void setUserId(Integer userId) {
        UserContext.userId.set(userId);
    }

    public static Integer getUserId() {
        return userId.get();
    }
}