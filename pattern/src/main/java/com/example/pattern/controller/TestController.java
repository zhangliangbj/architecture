package com.example.pattern.controller;

import com.example.spring_source_code.helper.DateHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangliang
 * @date 2019/10/30
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 测试获取时间
     */
    @GetMapping("/date")
    public String getDate(){
        DateHelper dateHelper = new DateHelper();
        Date d = dateHelper.getDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "当前时间："+simpleDateFormat.format(d);
    }


}
