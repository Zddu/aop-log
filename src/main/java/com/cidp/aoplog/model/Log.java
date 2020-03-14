package com.cidp.aoplog.model;


import lombok.Data;

@Data
public class Log {
    private Integer id;
    /**请求用户*/
    private String username;
    private String description;
    private String method;
    private String logType;
    private String requestIp;
    private String address;
    private String browser;
    private String createDate;

    public Log(String logType) {
        this.logType = logType;
    }
}
