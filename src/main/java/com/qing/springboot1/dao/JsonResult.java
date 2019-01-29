package com.qing.springboot1.dao;

public class JsonResult {

    private String status = null;
    private Object result = null;

    public JsonResult(String status, Object result) {
        this.status = status;
        this.result = result;
    }

    public JsonResult() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
