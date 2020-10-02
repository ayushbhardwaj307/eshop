package com.upgrad.eshop.dtos;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EshopUserDto {
    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String role;
    private LocalDateTime created;
    private LocalDateTime updated;
}
