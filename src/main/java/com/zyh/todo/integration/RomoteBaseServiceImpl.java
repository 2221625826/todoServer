package com.zyh.todo.integration;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zyh.todo.util.http.HttpClientTemplate;

/**
 * @author zhangyiheng03
 * @since 2022/5/19 15:54
 */

@Slf4j
public abstract class RomoteBaseServiceImpl {

    @Autowired
    protected HttpClientTemplate httpClientTemplate;

    protected static final Integer GET = 0;
    protected static final Integer POST = 1;

    /**
     * 加上前缀host
     * @param subUrl host
     * @return 全url
     */
    protected abstract String getFullUrl(String subUrl);

    /**
     * 获取响应结果
     */
    protected String getResponse(String subUrl, Integer type) {
        String fullUrl = getFullUrl(subUrl);
        try {
            return switch (type) {
                case 0 -> httpClientTemplate.executeGet(fullUrl);
                case 1 -> httpClientTemplate.executePost(fullUrl);
                default -> null;
            };
        } catch (IOException e) {
            log.error("[rpc:{}] failed e={}", fullUrl, e);
        }
        return null;
    }
    protected String getResponse(String subUrl, Map<String, String> params, Integer type) {
        String fullUrl = getFullUrl(subUrl);
        try {
            return switch (type) {
                case 0 -> httpClientTemplate.executeGet(fullUrl, httpClientTemplate.parseToNameValuePairs(params));
                case 1 -> httpClientTemplate.executePost(fullUrl, httpClientTemplate.parseToNameValuePairs(params));
                default -> null;
            };
        } catch (IOException e) {
            log.error("[rpc:{}] failed e={}", fullUrl, e);
        }
        return null;
    }
}