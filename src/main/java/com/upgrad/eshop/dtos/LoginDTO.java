package com.upgrad.eshop.dtos;

import lombok.Data;

@Data
public class LoginDTO {
    private String userName;
    private String password;
    private String message;
    String jwtToken;
}

