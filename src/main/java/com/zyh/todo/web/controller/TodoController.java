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

import com.zyh.todo.model.vo.TaskVO;
import com.zyh.todo.service.TagService;
import com.zyh.todo.service.TaskService;
import com.zyh.todo.util.exception.ServiceException;
import com.zyh.todo.util.http.AjaxResult;
import com.zyh.todo.web.UserContext;

/**
 * @author zhangyiheng03
 * @since 2022/6/2 15:32
 */
@RestController
@Slf4j
@RequestMapping("/todo")
public class TodoController extends BaseController {

    @Autowired
    TaskService taskService;

    @Autowired
    TagService tagService;

    /**
     * 添加任务
     * @param taskVO 任务
     * @return 是否成功
     */
    @PostMapping("/addTask")
    public AjaxResult addTask(@RequestBody TaskVO taskVO) {
        if (Objects.isNull(taskVO)) {
            return initFailureResult("参数错误");
        }
        log.info("[option:addTask]: taskVO={}", taskVO);
        try {
            return initSuccessResult(taskService.addTask(taskVO));
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
        Integer userId = UserContext.getUserId();
        if (Objects.isNull(userId) || userId == 0) {
            return initFailureResult("请登录");
        }
        return initSuccessResult(taskService.getTodo(userId));
    }

    /**
     * 获取已完成的任务
     * @return 任务列表
     */
    @ResponseBody
    @GetMapping("/getDone")
    public AjaxResult getDone() {
        Integer userId = UserContext.getUserId();
        if (Objects.isNull(userId) || userId == 0) {
            return initFailureResult("请登录");
        }
        return initSuccessResult(taskService.getDone(userId));
    }

    /**
     * 编辑指定任务
     * @param taskVO 新内容
     * @return 是否成功
     */
    @PostMapping("/editTask")
    public AjaxResult editTask(@RequestBody TaskVO taskVO) {
        if (Objects.isNull(taskVO)) {
            return initFailureResult("参数错误");
        }
        log.info("[option:editTask]: taskVO={}", taskVO);
        try {
            return initSuccessResult(taskService.editTask(taskVO));
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
        return initSuccessResult(taskService.doTask(id));
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
        return initSuccessResult(taskService.finishTask(id));
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
        return initSuccessResult(taskService.deprecatedTask(id));
    }

    /**
     * 获取所有tag
     * @return tag列表
     */
    @ResponseBody
    @GetMapping("/getTags")
    public AjaxResult getTags() {
        Integer userId = UserContext.getUserId();
        if (Objects.isNull(userId) || userId == 0) {
            return initFailureResult("请登录");
        }
        return initSuccessResult(tagService.getAll(userId));
    }

    /**
     * 新建tag
     * @param name tag名称
     * @return 是否成功
     */
    @GetMapping("/addTag")
    public AjaxResult addTag(@RequestParam String name) {
        Integer userId = UserContext.getUserId();
        if (Objects.isNull(userId) || userId == 0) {
            return initFailureResult("请登录");
        }
        return initSuccessResult(tagService.addTag(userId, name));
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