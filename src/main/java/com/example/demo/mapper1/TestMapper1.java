package com.example.demo.mapper1;

import com.example.demo.entity.ResponseResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper1 {
    List<ResponseResult> queryResponseResult();
}
