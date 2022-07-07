package com.zyh.todo.model.po;

import lombok.Data;

import org.springframework.beans.BeanUtils;

import com.zyh.todo.model.vo.TagVO;

@Data
public class TagPO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * userId
     */
    private Integer userId;

    /**
     * tag名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;

    public static TagPO of(TagVO tagVO) {
        TagPO res = new TagPO();
        BeanUtils.copyProperties(tagVO, res);
        return res;
    }

}