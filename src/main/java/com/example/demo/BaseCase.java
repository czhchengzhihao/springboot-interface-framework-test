package com.example.demo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest(classes = DemoApplication.class)
public abstract class BaseCase extends AbstractTestNGSpringContextTests {
}
