package com.zyh.todo.dal.mapper;

import com.zyh.todo.model.po.TagPO;
import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TagPO record);

    TagPO selectByPrimaryKey(Integer id);

    List<TagPO> selectAll();

    int updateByPrimaryKey(TagPO record);
}