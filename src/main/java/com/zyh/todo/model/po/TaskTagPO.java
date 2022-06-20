package com.zyh.todo.model.po;

import lombok.Data;

@Data
public class TaskTagPO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * tag表id
     */
    private Integer tagId;

    /**
     * 任务表id
     */
    private Integer taskId;

}