package com.example.demo;


import com.example.demo.mapper.querybooks.QueryBooksMapper;
import com.example.demo.mapper.responseresult.ResponseResultMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("aaa");
    }

    @Autowired
    private ResponseResultMapper responseResultMapper;
    @Autowired
    private QueryBooksMapper queryBooksMapper;

    @Test
    public void test1() {
        System.out.println(responseResultMapper.queryResponseResult());
        System.out.println(queryBooksMapper.queryBooks());
    }
}
