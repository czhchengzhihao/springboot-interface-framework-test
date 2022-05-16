package com.example.demo;

import com.example.demo.mapper1.TestMapper1;
import com.example.demo.mapper2.TestMapper2;
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
    private TestMapper1 testMapper1;
    @Autowired
    private TestMapper2 testMapper2;

    @Test
    public void test1() {
        System.out.println(testMapper1.queryResponseResult());
        System.out.println(testMapper2.queryBooks());
    }
}
