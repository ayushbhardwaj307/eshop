package com.upgrad.eshop.controllers;

import com.upgrad.eshop.dtos.EshopUserDto;
import com.upgrad.eshop.entities.EshopUser;
import com.upgrad.eshop.exceptions.APIException;
import com.upgrad.eshop.exceptions.UserAlreadyExistsException;
import com.upgrad.eshop.exceptions.UserDetailsNotfoundException;
import com.upgrad.eshop.security.JwtTokenProvider;
import com.upgrad.eshop.services.UserService;
import com.upgrad.eshop.utils.DTOEntityConverter;
import com.upgrad.eshop.utils.EntityDTOConverter;
import com.upgrad.eshop.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserService userService;
    @Autowired
    UserValidator userValidator;
    @Autowired
    EntityDTOConverter entityDTOConverter;
    @Autowired
    DTOEntityConverter dtoEntityConverter;

    @GetMapping( value = "/users/details")
    @ResponseBody
    public ResponseEntity getUserDetails(@RequestHeader(value = "X-ACCESS-TOKEN") String accessToken) throws UserAlreadyExistsException, APIException, UserDetailsNotfoundException {
        System.out.println("Details");
        String username = jwtTokenProvider.getUsername(accessToken);
        if(username == null) {
            throw new APIException("Please Login first to access this endpoint!");
        }
        EshopUser customer = userService.getCustomerDetailsByUserName(username);
        EshopUserDto savedCustomerDTO = entityDTOConverter.convertToUserDTO(customer);
        return ResponseEntity.status(HttpStatus.OK).body(savedCustomerDTO);
    }
}
