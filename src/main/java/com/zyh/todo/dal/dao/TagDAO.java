package com.zyh.todo.dal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zyh.todo.dal.mapper.TagMapper;
import com.zyh.todo.model.po.TagPO;

/**
 * @author zhangyiheng03
 * @since 2022/6/17 16:45
 */
@Repository
public class TagDAO {
    @Autowired
    TagMapper tagMapper;

    public List<TagPO> getAll(Integer userId) {
        return tagMapper.selectAll(userId);
    }

    public boolean delete(int id) {
        return tagMapper.deleteByPrimaryKey(id) == 1;
    }

    public boolean insert(TagPO record) {
        return tagMapper.insert(record) == 1;
    }

    public boolean update(TagPO record) {
        return tagMapper.updateByPrimaryKey(record) == 1;
    }

    public TagPO getById(int id) {
        return tagMapper.selectById(id);
    }


}