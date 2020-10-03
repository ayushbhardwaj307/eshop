package com.upgrad.eshop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Data
public class EshopOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private double amount;

    @Column
    private LocalDateTime orderDate;

    @JsonBackReference
    @ManyToOne
    private EshopUser eshopUser;

    @JsonBackReference
    @ManyToOne
    private EshopProduct eshopProduct;

    @JsonBackReference
    @ManyToOne
    private EshopShippingAddress eshopShippingAddress;
}
