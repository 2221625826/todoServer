package com.zyh.todo.dal.mapper;

import com.zyh.todo.model.po.TagPO;
import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TagPO record);

    List<TagPO> selectAll(Integer userId);

    int updateByPrimaryKey(TagPO record);

    TagPO selectById(Integer id);
}