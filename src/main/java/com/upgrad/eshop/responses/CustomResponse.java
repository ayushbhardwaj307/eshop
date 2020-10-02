package com.upgrad.eshop.responses;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class CustomResponse {
    private LocalDateTime timestamp;
    private String errorMessage;
    private int statusCode;

    public CustomResponse(String errorMessage, int statusCode) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }
    public CustomResponse(LocalDateTime timestamp, String errorMessage, int statusCode) {
        this.timestamp=timestamp;
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }
}
