package com.zyh.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.todo.dal.dao.TagDAO;
import com.zyh.todo.model.po.TagPO;
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
    public List<TagPO> getAll() {
        return tagDAO.getAll();
    }

    @Override
    public boolean addTag(String name) {
        TagPO tagPO = new TagPO();
        tagPO.setName(name);
        return tagDAO.insert(tagPO);
    }
}