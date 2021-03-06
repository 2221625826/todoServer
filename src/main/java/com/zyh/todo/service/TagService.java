package com.zyh.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zyh.todo.model.po.TagPO;
import com.zyh.todo.model.vo.TagVO;

/**
 * 标签
 * @author zhangyiheng03
 * @since 2022/6/17 17:02
 */
public interface TagService {

    /**
     * 获取所有标签
     * @return 标签列表
     */
    List<TagVO> getAll(int userId);

    /**
     * 插入标签
     * @param name 标签名
     * @return 是否成功
     */
    boolean addTag(int userId, String name);

    /**
     * 编辑tag
     * @param tagVO 需要修改的tag
     * @return 是否成功
     */
    boolean editTag(TagVO tagVO);

    boolean delTag(Integer id);
}