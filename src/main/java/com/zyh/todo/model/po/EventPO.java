package com.zyh.todo.model.po;

import lombok.Data;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.zyh.todo.model.vo.EventVO;
import com.zyh.todo.util.DateTimeUtil;

@Data
public class EventPO {
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
    private String tags;

    /**
     * 主题
     */
    private String topic;

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

    public static EventPO of(EventVO eventVO) {
        EventPO res = new EventPO();
        BeanUtils.copyProperties(eventVO, res);
        if (Objects.nonNull(eventVO.getTags())) {
            res.setTags(eventVO.getTags().toString());
        }
        if (!StringUtils.isBlank(eventVO.getCompleteTime())) {
            res.setCompleteTime(DateTimeUtil.parseStringToLong(eventVO.getCompleteTime(), DateTimeUtil.DATE_TIME_FORMAT));
        }
        return res;
    }
}