package com.example.demo.mapper2;

import org.apache.ibatis.annotations.Mapper;

import java.awt.print.Book;
import java.util.List;
@Mapper
public interface TestMapper2 {
    List<Book> queryBooks();
}
