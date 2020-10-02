package com.upgrad.eshop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class EshopShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String city;
    @Column
    private String landmark;
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String state;
    @Column
    private String street;
    @Column
    private String zipcode;
    @JsonBackReference
    @ManyToOne
    private EshopUser user;

}
