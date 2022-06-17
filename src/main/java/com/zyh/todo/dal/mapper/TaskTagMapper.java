package com.zyh.todo.dal.mapper;

import com.zyh.todo.model.po.TaskTagPO;
import java.util.List;

public interface TaskTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TaskTagPO record);

    TaskTagPO selectByPrimaryKey(Integer id);

    List<TaskTagPO> selectAll();

    int updateByPrimaryKey(TaskTagPO record);
}