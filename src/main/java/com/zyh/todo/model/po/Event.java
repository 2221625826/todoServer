package com.zyh.todo.model.po;

import lombok.Data;

@Data
public class Event {
    /**
     * id
     */
    private Integer id;

    /**
     * 优先级
     */
    private Byte priority;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String desc;

    /**
     * 标签
     */
    private String tag;

    /**
     * 主题
     */
    private String topic;

    /**
     * 状态
     */
    private Byte status;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 完成时间
     */
    private Long completeTime;
}