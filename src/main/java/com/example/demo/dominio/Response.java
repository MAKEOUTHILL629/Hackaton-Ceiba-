package com.example.demo.dominio;



public class Response {
    private String hostname;
    private String method;
    private String url;
    private String data;
    private String date;
    private int validitySeconds;
    private String token;

    public Response() {
    }

    public Response(String hostname, String method, String url, String data, String date, int validitySeconds, String token) {
        this.hostname = hostname;
        this.method = method;
        this.url = url;
        this.data = data;
        this.date = date;
        this.validitySeconds = validitySeconds;
        this.token = token;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getValiditySeconds() {
        return validitySeconds;
    }

    public void setValiditySeconds(int validitySeconds) {
        this.validitySeconds = validitySeconds;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
