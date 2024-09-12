package com.msig.phonebook.utility;

import lombok.Data;

@Data
public class ApiResponse {
    private boolean success;
    private String message;
    private Object data;

    public ApiResponse(){}

    public ApiResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
