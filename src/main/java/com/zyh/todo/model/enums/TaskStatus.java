package com.zyh.todo.model.enums;

import lombok.Getter;

/**
 * @author zhangyiheng03
 * @since 2022/6/13 11:02
 */
@Getter
public enum TaskStatus{
    TODO(0, "待办"),
    DOING(1, "进行中"),
    DONE(2, "已完成"),
    DEPRECATED(3, "已废弃");
    private final int code;

    private final String desc;

    TaskStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}