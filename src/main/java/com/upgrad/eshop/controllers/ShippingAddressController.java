package com.upgrad.eshop.controllers;

import com.upgrad.eshop.dtos.EshopShippingAddressDto;
import com.upgrad.eshop.entities.EshopShippingAddress;
import com.upgrad.eshop.entities.EshopUser;
import com.upgrad.eshop.exceptions.APIException;
import com.upgrad.eshop.exceptions.CustomException;
import com.upgrad.eshop.exceptions.UserAlreadyExistsException;
import com.upgrad.eshop.exceptions.UserDetailsNotfoundException;
import com.upgrad.eshop.security.JwtTokenProvider;
import com.upgrad.eshop.services.AddressService;
import com.upgrad.eshop.services.UserService;
import com.upgrad.eshop.utils.DTOEntityConverter;
import com.upgrad.eshop.utils.EntityDTOConverter;
import com.upgrad.eshop.validators.AddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShippingAddressController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    AddressService addressService;
    @Autowired
    UserService userService;
    @Autowired
    AddressValidator addressValidator;
    @Autowired
    EntityDTOConverter entityDTOConverter;
    @Autowired
    DTOEntityConverter dtoEntityConverter;

    @PostMapping( value = "/user-addresses")
    @ResponseBody
    public ResponseEntity addAddress(@RequestBody EshopShippingAddressDto addressDto, @RequestHeader(value = "X-ACCESS-TOKEN") String accessToken) throws UserAlreadyExistsException, APIException, UserDetailsNotfoundException, CustomException {
        System.out.println("Adding Address");
        String username = jwtTokenProvider.getUsername(accessToken);
        if(username == null)
            throw new APIException("Please Login first to access this endpoint!");

        EshopUser customer = userService.getCustomerDetailsByUserName(username);
        if(customer.getRole().equalsIgnoreCase("admin")){
            throw new CustomException("You are not authorised to access this endpoint.");
        }
        addressValidator.validateAddress(addressDto);
        EshopShippingAddress newAddress = dtoEntityConverter.convertToAddressEntity(addressDto);
        EshopShippingAddress savedAddress = addressService.createAddress(newAddress);
        savedAddress.setUser(customer);
        EshopShippingAddressDto savedAddressDTO = entityDTOConverter.convertToAddressSto(savedAddress);
        return ResponseEntity.status(HttpStatus.OK).body(savedAddressDTO);
    }
}
