package com.zyh.todo.model.po;

import lombok.Data;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.zyh.todo.model.vo.TaskVO;
import com.zyh.todo.util.DateTimeUtil;
@Data
public class TaskPO {
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
     * 主题id
     */
    private String topicId;

    /**
     * 状态
     */
    private Integer status;

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

    public static TaskPO of(TaskVO taskVO) {
        TaskPO res = new TaskPO();
        BeanUtils.copyProperties(taskVO, res);
        if (!StringUtils.isBlank(taskVO.getCompleteTime())) {
            res.setCompleteTime(DateTimeUtil.parseStringToLong(taskVO.getCompleteTime(), DateTimeUtil.DATE_TIME_FORMAT));
        } else {
            res.setCompleteTime(-1L);
        }
        return res;
    }

}