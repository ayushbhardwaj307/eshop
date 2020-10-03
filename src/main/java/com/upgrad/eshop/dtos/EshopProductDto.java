package com.upgrad.eshop.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EshopProductDto {

    private String name;
    private String category;
    private double price;
    private String description;
    private String manufacturer;
    private int availableItems;
    private String imageUrl;
    private LocalDateTime created;
    private LocalDateTime updated;
}
