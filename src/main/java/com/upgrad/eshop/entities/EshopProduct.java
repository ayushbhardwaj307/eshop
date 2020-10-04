package com.upgrad.eshop.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Data
public class EshopProduct {

    @Id
    @GeneratedValue
    private int product_id;
    @Column
    private int available_items;
    @Column
    private String category;
    @Column
    private LocalDateTime created;
    @Column(columnDefinition = "Varchar2(2000)")
    private String description;
    @Column
    private String image_url;
    @Column
    private String manufacturer;
    @Column
    private String name;
    @Column
    private double price;
    @Column
    private LocalDateTime updated;

    @OneToMany(mappedBy = "eshopProduct" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<EshopOrder> orders;

    public EshopProduct(){

    }

    public EshopProduct(int available_items, String category, LocalDateTime created, String description, String image_url, String manufacturer, String name, double price, LocalDateTime updated) {
        this.available_items = available_items;
        this.category = category;
        this.created = created;
        this.description = description;
        this.image_url = image_url;
        this.manufacturer = manufacturer;
        this.name = name;
        this.price = price;
        this.updated = updated;
    }
}
