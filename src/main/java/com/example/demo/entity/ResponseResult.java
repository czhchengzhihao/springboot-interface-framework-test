package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ChengZhiHao
 * @Description //TODO admin
 * @Date 15:14 2022/5/17
 * @Param
 * @return
 **/
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResponseResult {
    private int id;
    private String success;
    private String message;
    private String entity;
}
