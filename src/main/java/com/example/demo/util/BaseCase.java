package com.example.demo.util;

import com.example.demo.DemoApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * @Author ChengZhiHao
 * @Description //TODO SpringBoot集成TestNG
 * @Date 14:58 2022/5/17
 * @Param
 * @return
 **/
@SpringBootTest(classes = DemoApplication.class)
public abstract class BaseCase extends AbstractTestNGSpringContextTests {

}
