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
    @GeneratedValue(strategy = GenerationType.TABLE)
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
    @OneToMany(mappedBy = "eshopUser" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<EshopOrder> orders;
    public EshopUser(){
    }
    public EshopUser(LocalDateTime created,String email, String firstName, String lastName, String password, String phoneNo, String role, LocalDateTime updated, String userName) {
        this.created = created;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNo = phoneNo;
        this.role = role;
        this.updated = updated;
        this.userName = userName;
    }
}
