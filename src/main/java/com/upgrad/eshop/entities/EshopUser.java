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
public class EshopUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private LocalDateTime created;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String firstName;
    @Column
    private String lastName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String phoneNo;
    @Column
    private String role;
    @Column
    private LocalDateTime updated;
    @Column(nullable = false)
    private String userName;
    @OneToMany(mappedBy = "user" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<EshopShippingAddress> eshopShippingAddresses;
    public EshopUser(){
    }
}
