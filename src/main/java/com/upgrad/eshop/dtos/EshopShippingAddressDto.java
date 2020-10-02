package com.upgrad.eshop.dtos;

import com.upgrad.eshop.entities.EshopUser;
import lombok.Data;

@Data
public class EshopShippingAddressDto {
    private String name;
    private String phone;
    private String street;
    private String landmark;
    private String city;
    private String state;
    private String zipcode;
    private EshopUser user;
}
