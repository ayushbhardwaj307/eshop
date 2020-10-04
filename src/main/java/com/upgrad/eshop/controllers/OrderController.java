package com.upgrad.eshop.controllers;

import com.upgrad.eshop.dtos.EshopOrderDto;
import com.upgrad.eshop.dtos.EshopOrderResponseDto;
import com.upgrad.eshop.entities.EshopOrder;
import com.upgrad.eshop.entities.EshopUser;
import com.upgrad.eshop.exceptions.*;
import com.upgrad.eshop.responses.CustomResponse;
import com.upgrad.eshop.security.JwtTokenProvider;
import com.upgrad.eshop.services.AddressService;
import com.upgrad.eshop.services.OrderService;
import com.upgrad.eshop.services.ProductService;
import com.upgrad.eshop.services.UserService;
import com.upgrad.eshop.utils.DTOEntityConverter;
import com.upgrad.eshop.utils.EntityDTOConverter;
import com.upgrad.eshop.validators.OrderValidator;
import com.upgrad.eshop.validators.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;
    @Autowired
    AddressService addressService;
    @Autowired
    UserService userService;
    @Autowired
    ProductValidator productValidator;
    @Autowired
    OrderValidator orderValidator;
    @Autowired
    EntityDTOConverter entityDTOConverter;
    @Autowired
    DTOEntityConverter dtoEntityConverter;


    @PostMapping( value = "/orders")
    @ResponseBody
    public ResponseEntity createProduct(@RequestBody EshopOrderDto orderDto, @RequestHeader(value = "X-ACCESS-TOKEN") String accessToken) throws APIException, UserDetailsNotfoundException, CustomException, ProductDetailsNotFound, AddressNotFound {
        System.out.println("Creating Product");
        String username = jwtTokenProvider.getUsername(accessToken);
        if(username == null)
            throw new APIException("Please Login first to access this endpoint!");

        EshopUser customer = userService.getCustomerDetailsByUserName(username);
        if(!customer.getRole().equalsIgnoreCase("user")){
            throw new CustomException("You are not authorised to access this endpoint.");
        }
        orderValidator.validateOrder(orderDto);
        if(productService.getProductDetailsById(orderDto.getProductId())==null){
            CustomResponse response = new CustomResponse(LocalDateTime.now(), "No Product found for ID - "+orderDto.getProductId()+"!", 400);
            return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        List<EshopOrder> orders=orderService.getOrders();
        for(EshopOrder o:orders) {
            if (orderDto.getProductId()==o.getEshopProduct().getProduct_id()) {
                CustomResponse response = new CustomResponse(LocalDateTime.now(), "Product with ID - "+orderDto.getProductId()+" is currently out of stock!", 400);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        }
        if(addressService.getAddressDetailsById(orderDto.getAddressId())==null){
            CustomResponse response = new CustomResponse(LocalDateTime.now(), "No Address found for ID - "+orderDto.getProductId()+"!", 400);
            return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        EshopOrder newOrder = dtoEntityConverter.convertToOrderEntity(orderDto);
        EshopOrder savedOrder = orderService.createOrder(newOrder);
        EshopOrderResponseDto savedProductDTO = entityDTOConverter.convertToResponseDto(savedOrder);
        return ResponseEntity.status(HttpStatus.OK).body(savedProductDTO);

    }
}
