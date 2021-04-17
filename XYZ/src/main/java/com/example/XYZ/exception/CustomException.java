package com.example.XYZ.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends Exception{
    private HttpStatus statusCode;
    private String status = "error";
    private String message;

    public CustomException setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public CustomException setStatus(String status) {
        this.status = status;
        return this;
    }

    public CustomException setMessage(String message) {
        this.message = message;
        return this;
    }
}
