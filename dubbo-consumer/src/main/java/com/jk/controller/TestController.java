package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {

    @Reference
    private TestService testService;


    @RequestMapping("testq")
    @ResponseBody
    public  String  test(){
      return    testService.test();

    }
}
