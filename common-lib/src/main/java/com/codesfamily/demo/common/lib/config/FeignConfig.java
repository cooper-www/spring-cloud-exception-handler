package com.codesfamily.demo.common.lib.config;

import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig extends FeignClientsConfiguration {

    @Bean
    public ErrorDecoder errorDecoder(){
        return new FeignErrorDecoder();
    }
}
