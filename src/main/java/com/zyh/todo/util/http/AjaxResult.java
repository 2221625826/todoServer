package com.zyh.todo.util.http;

import com.zyh.todo.model.enums.HttpCode;
import lombok.AllArgsConstructor;

/**
 * @author zhangyiheng03
 * @since 2022/5/18 14:51
 */

@AllArgsConstructor
public class AjaxResult {
    /**
     * HTTP响应码
     */
    public Integer code;

    /**
     * 消息
     */
    public String msg;

    /**
     * 结果
     */
    public Object result;

    public AjaxResult(HttpCode code, String msg, Object result) {
        this.code = code.getCode();
        this.msg = msg;
        this.result = result;
    }

    public AjaxResult(HttpCode code, String msg) {
        this.code = code.getCode();
        this.msg = msg;
    }

    public AjaxResult(HttpCode code, Object result) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.result = result;
    }

    public AjaxResult(HttpCode code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }
}