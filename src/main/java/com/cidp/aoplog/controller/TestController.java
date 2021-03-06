package com.cidp.aoplog.controller;

import com.cidp.aoplog.aop.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Log("更新操作")
    @GetMapping("/hello")
    public String hello(){
        return "aop log1";
    }

    @Log("删除测试")
    @GetMapping("/test")
    public String hello2(){
        return "aop log2";
    }
}
