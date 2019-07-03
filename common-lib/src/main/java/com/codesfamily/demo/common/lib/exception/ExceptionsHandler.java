package com.codesfamily.demo.common.lib.exception;

import com.alibaba.fastjson.JSON;
import com.codesfamily.demo.contract.model.Resp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ExceptionsHandler {
    private Logger logger = LoggerFactory.getLogger(ExceptionsHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public void handle(Exception ex, HttpServletResponse response)throws IOException {
        logger.error(ex.getMessage(),ex);
        response.addHeader("exception",ex.getClass().getSimpleName());
        if (response.getStatus() == 500 || ex instanceof BusinessException){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            Resp resp = new Resp();
            resp.setMessage(ex.getMessage());
            if (ex instanceof BusinessException){
                BusinessException be = (BusinessException)ex;
                resp.setCode(be.getCode());
            }
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JSON.toJSONString(resp));
        }
    }
}
