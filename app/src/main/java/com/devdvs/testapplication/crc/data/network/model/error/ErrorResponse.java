package com.devdvs.testapplication.crc.data.network.model.error;

public class ErrorResponse {

    private String name;
    private String pattern;
    private String message;

    public ErrorResponse() {}

    public ErrorResponse(String name, String pattern, String message) {
        this.name = name;
        this.pattern = pattern;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
