package com.zyh.todo.model.vo;

import lombok.Data;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.zyh.todo.model.po.EventPO;
import com.zyh.todo.util.DateTimeUtil;

@Data
public class EventVO {
    /**
     * id
     */
    private Integer id;

    /**
     * 优先级
     */
    private Integer priority;

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
    private Integer status;

    /**
     * 完成时间
     */
    private String completeTime;

    public static EventVO of(EventPO eventPO) {
        EventVO res = new EventVO();
        BeanUtils.copyProperties(eventPO, res);
        if (Objects.nonNull(eventPO.getTags())) {
            int start = 1, end = eventPO.getTags().length() - 1;
            res.setTags(List.of(eventPO.getTags().substring(start, end).split(",")));
        }
        if (Objects.nonNull(eventPO.getCompleteTime()) && eventPO.getCompleteTime() != -1) {
            res.setCompleteTime(DateTimeUtil.parseLongToString(eventPO.getCompleteTime(), DateTimeUtil.DATE_TIME_FORMAT));
        }
        return res;
    }
}