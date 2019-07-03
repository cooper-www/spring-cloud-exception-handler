package com.codesfamily.demo.contract.model;

public class Resp<T> {

    private int code;

    private String message;

    private T body;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }


    public static <T> Resp<T> success(T body){
        Resp<T> resp = new Resp<>();
        resp.setCode(2000);
        resp.setMessage("ok");
        resp.setBody(body);
        return resp;
    }
}
