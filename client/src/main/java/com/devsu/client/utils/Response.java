package com.devsu.client.utils;

import org.springframework.http.HttpStatus;

public class Response<T> {

    private String response;
    private T json;

    private HttpStatus code;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public T getJson() {
        return json;
    }

    public void setJson(T json) {
        this.json = json;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }
}
