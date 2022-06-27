package com.zyh.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zyh.todo.model.po.TagPO;

/**
 * @author zhangyiheng03
 * @since 2022/6/17 17:02
 */
public interface TagService {

    /**
     * 获取所有标签
     * @return 标签列表
     */
    List<TagPO> getAll(int userId);

    /**
     * 插入标签
     * @param name 标签名
     * @return 是否成功
     */
    boolean addTag(int userId, String name);
}