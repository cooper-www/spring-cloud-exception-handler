package com.codesfamily.demo.api.controller;

import com.codesfamily.demo.contract.model.Resp;
import com.codesfamily.demo.provider.contract.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/sayHello")
    public Resp<String> sayHello(){
        return Resp.success(testService.sayHello());
    }
}
