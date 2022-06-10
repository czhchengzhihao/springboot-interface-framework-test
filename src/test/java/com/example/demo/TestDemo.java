package com.example.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


import com.example.demo.entity.ResponseResult;
import com.example.demo.httputil.HttpGetUtil;
import com.example.demo.mapper.responseresult.ResponseResultMapper;
import com.example.demo.mapper.querybooks.QueryBooksMapper;
import com.example.demo.util.BaseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;


import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class TestDemo extends BaseCase {


    @Autowired
    private ResponseResultMapper responseResultMapper;
    @Autowired
    private QueryBooksMapper queryBooksMapper;


    @Test
    public void test1() {

        log.info(JSONObject.toJSONString(responseResultMapper.queryResponseResult("测试")));
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

    @Test
    public void test3() {
        JSONObject jsonObject = HttpGetUtil.httpGet("testUrl", "aa");
        System.out.println(jsonObject);
    }

    @Test
    public void test4() {
        List<ResponseResult> data = responseResultMapper.queryResponseResult("测试");
        System.out.println(data + "aaaaaaa");
        String s = JSONObject.toJSONString(data);
        System.out.println(JSONArray.parseArray(s).size() + "aaaa");
        System.out.println(JSONArray.parseArray(s).getJSONObject(0).size() + "aaa");
        Object[][] dataS = new Object[JSONArray.parseArray(s).size()][JSONArray.parseArray(s).getJSONObject(0).size()];
        System.out.println(JSONArray.parseArray(s).size() + "行");
        System.out.println(JSONArray.parseArray(s).getJSONObject(0).size() + "列");
        for (int i = 0; i < JSONArray.parseArray(s).size(); i++) {
            for (int j = 0; j < JSONArray.parseArray(s).getJSONObject(i).size(); j++) {
                dataS[i][j] = JSONArray.parseArray(s).getJSONObject(i).keySet();
            }
        }
        for (Object[] objects : dataS) {
            for (Object object : objects) {
                System.out.print("{" + object + "}");
            }
            System.out.println();
        }




      /*  Object[][] dataS = new Object[JSONArray.parseArray(s).size()][JSONArray.parseArray(s).getJSONObject(1).size()];
        for (int i = 0; i < JSONArray.parseArray(s).size(); i++) {
            JSONObject jsonObject = JSONArray.parseArray(s).getJSONObject(1);
            for (int j = 0; j < JSONArray.parseArray(s).getJSONObject(i).size(); j++) {
                JSONObject jsonObject1 = JSONArray.parseArray(s).getJSONObject(1);
                dataS[i][j] = jsonObject1;
            }
            for (Object[] objects : dataS) {
                for (Object object : objects) {
                    System.out.print("{" + object + "}");
                   // System.out.println(object);
                }
                System.out.println();
            }
        }*/

    }

    @Test
    public void test44() {
        List<ResponseResult> data = responseResultMapper.queryResponseResult("测试");
        System.out.println(data + "aaaaaaa");
        String s = JSONObject.toJSONString(data);
        System.out.println(JSONArray.parseArray(s).size() + "aaaa");
        System.out.println(JSONArray.parseArray(s).getJSONObject(0).size() + "aaa");
        Object[][] dataS = new Object[JSONArray.parseArray(s).size()][JSONArray.parseArray(s).getJSONObject(0).size()];
        System.out.println(JSONArray.parseArray(s).size() + "行");
        System.out.println(JSONArray.parseArray(s).getJSONObject(0).size() + "列");
        for (int i = 0; i < JSONArray.parseArray(s).size(); i++) {
            JSONObject jsonObject = JSONArray.parseArray(s).getJSONObject(i);
            System.out.println(jsonObject);
            Set<String> strings = jsonObject.keySet();
            int j = 1;
            for (String string : strings) {
                dataS[i][j++] = jsonObject.get(string).toString();
            }

        }
        for (Object[] objects : dataS) {
            for (Object object : objects) {
                System.out.print("{" + object + "}");
            }
            System.out.println();
        }
    }
}
