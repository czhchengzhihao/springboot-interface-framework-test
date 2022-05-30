package com.example.demo.casedata;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.ResponseResult;
import com.example.demo.mapper.responseresult.ResponseResultMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

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
    private static ResponseResultMapper responseResultMapper;

    public static Object[][] dataS() {
        List<ResponseResult> data = responseResultMapper.queryResponseResult("测试");
        String s = JSONObject.toJSONString(data);
        System.out.println(s+"1111111111111111111111");
        Object[][] parse = JSONObject.parseObject(s, Object[][].class);
        System.out.println(parse+"22222222222");
        return parse;
    }

}
