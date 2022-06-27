package com.zyh.todo.model.vo;

import lombok.Data;

import org.springframework.beans.BeanUtils;

import com.zyh.todo.model.po.TagPO;

/**
 * @author zhangyiheng03
 * @since 2022/6/27 14:44
 */
@Data
public class TagVO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * tag名称
     */
    private String name;

    public static TagVO of(TagPO tagPO) {
        TagVO res = new TagVO();
        BeanUtils.copyProperties(tagPO, res);
        return res;
    }
}