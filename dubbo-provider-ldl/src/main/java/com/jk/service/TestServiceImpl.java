package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(interfaceClass = TestService.class)
@Component
public class TestServiceImpl implements TestService {

    @Override
    public String test() {
        return "jijklja";
    }




}
