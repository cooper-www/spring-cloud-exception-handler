package com.codesfamily.demo.common.lib.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codesfamily.demo.common.lib.exception.BusinessException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;

public class FeignErrorDecoder implements ErrorDecoder {

    private Logger logger = LoggerFactory.getLogger(FeignErrorDecoder.class);
    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            String respText = IOUtils.toString(response.body().asInputStream(), StandardCharsets.UTF_8.name());
            JSONObject respObj = JSON.parseObject(respText);
            Map<String, Collection<String>> headers = response.headers();
            if (headers != null && headers.containsKey("exception")) {
                String exType = headers.get("exception").stream().findFirst().orElse(null);
                if (exType != null && exType.equalsIgnoreCase(BusinessException.class.getSimpleName())){
                    int code = respObj.getIntValue("code");
                    String message = respObj.getString("message");
                    BusinessException be = new BusinessException(message,code);
                    return be;
                }
            }
            return new RuntimeException(respText);
        } catch (Throwable e) {
            return new RuntimeException(e);
        }
    }
}
