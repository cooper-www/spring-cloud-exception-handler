package com.codesfamily.demo.provider.contract;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("provider-demo1")
public interface TestService {

    @GetMapping("/TestService/sayHello")
    String sayHello();
}
