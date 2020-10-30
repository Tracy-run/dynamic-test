package com.dynamic.util;

import java.io.Serializable;

/**
 * @Author: 逍遥子
 * @Date: 2020/10/21 15:56
 */
public class WebResponseBody implements Serializable {

    private String msg;
    private Object body;
    private int code;

    public WebResponseBody(int code, String msg, Object body) {
        this.msg = msg;
        this.body = body;
        this.code = code;
    }

    public WebResponseBody(int code, Object body) {
        this.body = body;
        this.code = code;
    }


    public Object getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
