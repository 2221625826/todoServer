package com.zyh.todo.model.vo;

import lombok.Data;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.zyh.todo.model.po.TagPO;
import com.zyh.todo.model.po.TaskPO;
import com.zyh.todo.util.DateTimeUtils;

@Data
public class TaskVO {
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
    private List<TagPO> tags;

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

    public static TaskVO of(TaskPO taskPO) {
        TaskVO res = new TaskVO();
        BeanUtils.copyProperties(taskPO, res);
        if (Objects.nonNull(taskPO.getCompleteTime()) && taskPO.getCompleteTime() != -1) {
            res.setCompleteTime(DateTimeUtils.parseLongToString(taskPO.getCompleteTime(), DateTimeUtils.DATE_TIME_FORMAT));
        } else {
            res.setCompleteTime("");
        }
        return res;
    }
}