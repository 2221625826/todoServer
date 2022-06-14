package com.zyh.todo.web.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.todo.model.vo.EventVO;
import com.zyh.todo.service.EventService;
import com.zyh.todo.util.exception.ServiceException;
import com.zyh.todo.util.http.AjaxResult;

/**
 * @author zhangyiheng03
 * @since 2022/6/2 15:32
 */
@RestController
@Slf4j
@RequestMapping("/todo")
public class TodoController extends BaseController {

    @Autowired
    EventService eventService;

    /**
     * 添加任务
     * @param eventVO 任务
     * @return 是否成功
     */
    @PostMapping("/addTask")
    public AjaxResult addTask(@RequestBody EventVO eventVO) {
        if (Objects.isNull(eventVO)) {
            return initFailureResult("参数错误");
        }
        log.info("[option:addTask]: eventVO={}", eventVO);
        try {
            return initSuccessResult(eventService.addTask(eventVO));
        } catch (ServiceException e) {
            return initFailureResult(e.getMessage());
        }

    }

    /**
     * 获取未开始和进行中的任务
     * @return 任务列表
     */
    @ResponseBody
    @GetMapping("/getTodo")
    public AjaxResult getTodo() {
        return initSuccessResult(eventService.getTodo());
    }

    /**
     * 获取已完成的任务
     * @return 任务列表
     */
    @ResponseBody
    @GetMapping("/getDone")
    public AjaxResult getDone() {
        return initSuccessResult(eventService.getDone());
    }

    /**
     * 编辑指定任务
     * @param eventVO 新内容
     * @return 是否成功
     */
    @PostMapping("/editTask")
    public AjaxResult editTask(@RequestBody EventVO eventVO) {
        if (Objects.isNull(eventVO)) {
            return initFailureResult("参数错误");
        }
        log.info("[option:editTask]: eventVO={}", eventVO);
        try {
            return initSuccessResult(eventService.editTask(eventVO));
        } catch (ServiceException e) {
            return initFailureResult(e.getMessage());
        }
    }

    /**
     * 开始进行指定任务
     * @param id 任务id
     * @return 是否成功
     */
    @GetMapping("/doTask")
    public AjaxResult doTask(@RequestParam Integer id) {
        if (Objects.isNull(id) || id < 0) {
            return initFailureResult("参数错误");
        }
        log.info("[option:doTask]: id={}", id);
        return initSuccessResult(eventService.doTask(id));
    }

    /**
     * 结束任务
     * @param id 任务id
     * @return 是否成功
     */
    @GetMapping("/finishTask")
    public AjaxResult finishTask(@RequestParam Integer id) {
        if (Objects.isNull(id) || id < 0) {
            return initFailureResult("参数错误");
        }
        log.info("[option:finishTask]: id={}", id);
        return initSuccessResult(eventService.finishTask(id));
    }

    /**
     * 废弃任务
     * @param id 任务id
     * @return 是否成功
     */
    @GetMapping("/deprecatedTask")
    public AjaxResult deprecatedTask(@RequestParam Integer id) {
        if (Objects.isNull(id) || id < 0) {
            return initFailureResult("参数错误");
        }
        log.info("[option:deprecatedTask]: id={}", id);
        return initSuccessResult(eventService.deprecatedTask(id));
    }

    /**
     * 获取所有tag
     * @return tag列表
     */
    @ResponseBody
    @GetMapping("/getTags")
    public AjaxResult getTags() {
        return initSuccessResult();
    }

    /**
     * 获取所有topic
     * @return topic列表
     */
    @ResponseBody
    @GetMapping("/getTopics")
    public AjaxResult getTopics() {
        return initSuccessResult();
    }
}