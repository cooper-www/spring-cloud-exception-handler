package com.codesfamily.demo.provider.demo1.impl;

import com.codesfamily.demo.common.lib.exception.BusinessException;
import com.codesfamily.demo.provider.contract.TestService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServiceImpl implements TestService {
    @Override
    public String sayHello() {
        throw new BusinessException("错误",500001);
    }
}
