package com.zyh.todo.model.enums;

import lombok.Getter;

import java.util.Map;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

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

    public static Map<Integer, String> getMap() {
        Map<Integer, String> res = Maps.newHashMap();
        for (TaskStatus ts : TaskStatus.values()) {
            res.put(ts.getCode(), ts.getDesc());
        }
        return res;
    }
}