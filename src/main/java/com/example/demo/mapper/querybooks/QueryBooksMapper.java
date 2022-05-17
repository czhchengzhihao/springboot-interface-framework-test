package com.example.demo.mapper.querybooks;

import org.apache.ibatis.annotations.Mapper;

import java.awt.print.Book;
import java.util.List;

/**
 * @author admin
 */
@Mapper
public interface QueryBooksMapper {
    List<Book> queryBooks();
}
