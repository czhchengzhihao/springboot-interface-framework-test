package com.example.demo.mapper.querybooks;


import com.example.demo.entity.Books;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 */
@Mapper
public interface QueryBooksMapper {
    List<Books> queryBooks();
}
