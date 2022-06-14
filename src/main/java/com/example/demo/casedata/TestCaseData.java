package com.example.demo.casedata;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.ResponseResult;
import com.example.demo.mapper.responseresult.ResponseResultMapper;
import com.example.demo.util.ReadDataBaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;

import java.util.List;

/**
 * @PackageName: com.example.demo.casedata
 * @ClassName: TestCaseData
 * @Description: TestCaseData/description:
 * @Author: ChengZhiHao
 * @Date: 2022/5/17 16:21
 * @Version: v1.0
 */
@Slf4j
public class TestCaseData {

    @Autowired
    private ResponseResultMapper responseResultMapper;

    @DataProvider(name = "bb")
    public Object[][] yy() {
        List<ResponseResult> data = responseResultMapper.queryResponseResult("测试");
        String parameter = JSONObject.toJSONString(data);
        return ReadDataBaseUtil.readDataBase(parameter);
    }
}
