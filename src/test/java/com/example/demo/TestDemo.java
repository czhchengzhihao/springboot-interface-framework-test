package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.ResponseResult;
import com.example.demo.mapper1.TestMapper1;
import com.example.demo.mapper2.TestMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

public class TestDemo extends BaseCase {

    @Autowired
    private TestMapper1 testMapper1;
    @Autowired
    private TestMapper2 testMapper2;

    @Test
    public void test1() {
        List<ResponseResult> responseResults = testMapper1.queryResponseResult();
        String s = JSONObject.toJSONString(responseResults);
        System.out.println(s);
      /*  System.out.println(testMapper1.queryResponseResult());
        System.out.println(testMapper2.queryBooks());*/

    }

}
