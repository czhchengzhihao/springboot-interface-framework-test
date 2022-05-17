package com.example.demo;

import com.alibaba.fastjson.JSONObject;

import com.example.demo.mapper.responseresult.ResponseResultMapper;
import com.example.demo.mapper.querybooks.QueryBooksMapper;
import com.example.demo.util.BaseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

@Slf4j
public class TestDemo extends BaseCase {


    @Autowired
    private ResponseResultMapper responseResultMapper;
    @Autowired
    private QueryBooksMapper queryBooksMapper;


    @Test
    public void test1() {

        log.info(JSONObject.toJSONString(responseResultMapper.queryResponseResult()));
        log.info(JSONObject.toJSONString(queryBooksMapper.queryBooks()));


    }

    @Test
    public void test2() {
        for (int i = 0; i < 1; i++) {
            log.debug("debug");
            log.info("info");
            log.warn("warn");
            log.error("error");
            log.info("-------------------------" + i);
        }
        log.info("------------------end---------------------");

    }

}
