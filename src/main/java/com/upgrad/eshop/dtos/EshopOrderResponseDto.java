package com.upgrad.eshop.dtos;

import com.upgrad.eshop.entities.EshopProduct;
import com.upgrad.eshop.entities.EshopShippingAddress;
import com.upgrad.eshop.entities.EshopUser;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EshopOrderResponseDto {
    private int id;
    private EshopUser eshopUser;
    private EshopProduct eshopProduct;
    private EshopShippingAddress eshopShippingAddress;
    private double amount;
    private LocalDateTime orderDate;
}
