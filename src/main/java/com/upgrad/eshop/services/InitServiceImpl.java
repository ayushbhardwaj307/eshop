package com.upgrad.eshop.services;

import com.upgrad.eshop.daos.EshopProductDAO;
import com.upgrad.eshop.daos.EshopUserDAO;
import com.upgrad.eshop.entities.EshopProduct;
import com.upgrad.eshop.entities.EshopUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;


@Service("InitService")
public class InitServiceImpl implements InitService {

    @Qualifier("eshopUserDAO")
    @Autowired
    private EshopUserDAO usersDAO;

    @Qualifier("eshopProductDAO")
    @Autowired
    private EshopProductDAO eshopProductDAO;


    EshopUser users = new EshopUser(LocalDateTime.now(), "admin@upgrad.com", "admin", "admin", "password", "1111111111", "ADMIN", LocalDateTime.now(), "admin");
    List<EshopUser> usersDataList= Collections.singletonList(users);
    EshopProduct product=new EshopProduct(25, "Automotive", LocalDateTime.now(), "Himmlisch ST381 Magnetic Sun Shade For Maruti Alto (Side Window) Price: Rs. 1 899 Beat the heat this summer and feel like a VIP with Himmlisch Car Window Magnetic Sunshades. These magnetic sunshades create a mesh layer to stops the heat. Magnet border gets easily stick to your car window door edges (No need of Suction cups) Features: Block UV Rays Keeps Car Cool Easy to install and remove Durable and Exact Fit Provides Complete privacy Resists Heat Mesh Type Sunshade Package Contents: 1 x Set Of 4 Magnetic Sunshades Specifications of Himmlisch ST381 Magnetic Sun Shade For Maruti Alto (Side Window) General Brand Himmlisch Model Number ST381 Magnetic Placement Position Side Window Color Black Dimensions Weight 4000 g Depth 1.1 cm In the Box Sales Package 4 Sun Shade Pack of 4", "http://img5a.flixcart.com/image/sun-shade/5/2/y/pp48-car-magnetic-himmlisch-1100x1100-imaegujvyzrc8eh6.jpeg", "Himmlisch", "Himmlisch ST381 Magnetic Sun Shade For Maruti Alto", 6999, LocalDateTime.now());
    List<EshopProduct> productList= Collections.singletonList(product);

    @Override
    public void init() {
        usersDataList.forEach(usersData -> usersDAO.save(usersData));
        productList.forEach( productData -> eshopProductDAO.save(productData));
    }
}
