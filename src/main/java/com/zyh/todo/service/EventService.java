package com.zyh.todo.service;

import java.util.List;

import com.zyh.todo.model.vo.EventVO;

/**
 * @author zhangyiheng03
 * @since 2022/6/2 15:27
 */

public interface EventService {
    /**
     * 获取所有事件
     * @return 事件列表
     */
    List<EventVO> getAll();

    /**
     * 添加任务
     * @param eventVO 参数
     * @return 是否成功
     */
    Boolean addTask(EventVO eventVO);
}