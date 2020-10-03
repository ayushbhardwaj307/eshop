package com.upgrad.eshop.utils;

import com.upgrad.eshop.dtos.EshopProductDto;
import com.upgrad.eshop.dtos.EshopShippingAddressDto;
import com.upgrad.eshop.dtos.EshopUserDto;
import com.upgrad.eshop.dtos.LoginDTO;
import com.upgrad.eshop.entities.EshopProduct;
import com.upgrad.eshop.entities.EshopShippingAddress;
import com.upgrad.eshop.entities.EshopUser;
import com.upgrad.eshop.exceptions.UserAlreadyExistsException;
import com.upgrad.eshop.exceptions.UserDetailsNotfoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DTOEntityConverter {
    public EshopUser convertToUserEntity(EshopUserDto userDto) throws UserDetailsNotfoundException, UserAlreadyExistsException {
        EshopUser usersData = new EshopUser();
        usersData.setFirstName(userDto.getFirstName());
        usersData.setLastName(userDto.getLastName());
        usersData.setEmail(userDto.getEmail());
        usersData.setPhoneNo(userDto.getPhoneNumber());
        usersData.setPassword(userDto.getPassword());
        usersData.setUserName(userDto.getUserName());
        usersData.setId(userDto.getId());
        usersData.setCreated(userDto.getCreated());
        usersData.setUpdated(userDto.getUpdated());
        usersData.setRole(userDto.getRole());
        return usersData;
    }

    public EshopUser convertToLogin(LoginDTO userDto) throws UserDetailsNotfoundException, UserAlreadyExistsException {
        EshopUser usersData = new EshopUser();
        usersData.setPassword(userDto.getPassword());
        usersData.setUserName(userDto.getUserName());
        return usersData;
    }

    public EshopShippingAddress convertToAddressEntity(EshopShippingAddressDto addressDto) throws UserDetailsNotfoundException, UserAlreadyExistsException {
        EshopShippingAddress addressData= new EshopShippingAddress();
        addressData.setCity(addressDto.getCity());
        addressData.setLandmark(addressDto.getLandmark());
        addressData.setName(addressDto.getName());
        addressData.setPhone(addressDto.getPhone());
        addressData.setState(addressDto.getState());
        addressData.setStreet(addressDto.getStreet());
        addressData.setZipcode(addressDto.getZipcode());
        return addressData;
    }

    public EshopProduct convertToProductEntity(EshopProductDto productDto) {
        EshopProduct productData= new EshopProduct();
        productData.setAvailable_items(productDto.getAvailableItems());
        productData.setCategory(productDto.getCategory());
        productData.setCreated(LocalDateTime.now());
        productData.setDescription(productDto.getDescription());
        productData.setImage_url(productDto.getImageUrl());
        productData.setManufacturer(productDto.getManufacturer());
        productData.setName(productDto.getName());
        productData.setPrice(productDto.getPrice());
        productData.setUpdated(LocalDateTime.now());
        return productData;
    }
}
