package com.zyh.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.zyh.todo.dal.dao.TagDAO;
import com.zyh.todo.model.po.TagPO;
import com.zyh.todo.model.vo.TagVO;
import com.zyh.todo.service.TagService;

/**
 * @author zhangyiheng03
 * @since 2022/6/20 11:27
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagDAO tagDAO;
    @Override
    public List<TagVO> getAll(int userId) {
        List<TagVO> tagList = Lists.newArrayList();
        for (TagPO tagPO : tagDAO.getAll(userId)) {
            tagList.add(TagVO.of(tagPO));
        }
        return tagList;
    }

    @Override
    public boolean addTag(int userId, String name) {
        TagPO tagPO = new TagPO();
        tagPO.setUserId(userId);
        tagPO.setName(name);
        return tagDAO.insert(tagPO);
    }
}