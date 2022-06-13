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

    @ResponseBody
    @GetMapping("/getAll")
    public AjaxResult getAll() {
        return initSuccessResult(eventService.getAll());
    }

    @PostMapping("/addTask")
    public AjaxResult addTask(@RequestBody EventVO eventVO) {
        if (Objects.isNull(eventVO)) {
            return initFailureResult("参数错误");
        }
        log.info("[option:addTask]: eventVO={}", eventVO);
        return initSuccessResult(eventService.addTask(eventVO));
    }

    @ResponseBody
    @GetMapping("/getTodo")
    public AjaxResult getTodo() {
        return initSuccessResult(eventService.getTodo());
    }

    @ResponseBody
    @GetMapping("/getDone")
    public AjaxResult getDone() {
        return initSuccessResult(eventService.getDone());
    }

    @GetMapping("/editTask")
    public AjaxResult editTask(@RequestBody EventVO eventVO) {
        return initSuccessResult(eventService.editTask(eventVO));
    }

    @GetMapping("/doTask")
    public AjaxResult doTask(@RequestParam Integer id) {
        return initSuccessResult(eventService.doTask(id));
    }

    @GetMapping("/finishTask")
    public AjaxResult finishTask(@RequestParam Integer id) {
        return initSuccessResult(eventService.finishTask(id));
    }

    @GetMapping("/deprecatedTask")
    public AjaxResult deprecatedTask(@RequestParam Integer id) {
        return initSuccessResult(eventService.deprecatedTask(id));
    }
}