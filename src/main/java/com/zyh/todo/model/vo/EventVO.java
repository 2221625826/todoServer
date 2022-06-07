package com.zyh.todo.model.vo;

import lombok.Data;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.zyh.todo.model.po.EventPO;

@Data
public class EventVO {
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
    private List<String> tags;

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

    public static EventVO of(EventPO eventPO) {
        EventVO res = new EventVO();
        BeanUtils.copyProperties(eventPO, res);
        int start = 1, end = eventPO.getTags().length() - 1;
        res.setTags(List.of(eventPO.getTags().substring(start, end).split(",")));
        return res;
    }
}