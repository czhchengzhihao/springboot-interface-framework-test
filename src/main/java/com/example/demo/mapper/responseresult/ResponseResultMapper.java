package com.example.demo.mapper.responseresult;

import com.example.demo.entity.ResponseResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 */
@Mapper
public interface ResponseResultMapper {

    List<ResponseResult> queryResponseResult(String remark);

}
