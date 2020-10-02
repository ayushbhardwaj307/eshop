package com.upgrad.eshop.utils;

import com.upgrad.eshop.dtos.EshopUserDto;
import com.upgrad.eshop.dtos.LoginDTO;
import com.upgrad.eshop.entities.EshopUser;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConverter {



    public EshopUserDto convertToUserDTO(EshopUser customer){
        EshopUserDto customerDTO = new EshopUserDto();
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhoneNumber(customer.getPhoneNo());
        customerDTO.setUserName(customer.getUserName());
        customerDTO.setId(customer.getId());
        customerDTO.setCreated(customer.getCreated());
        customerDTO.setUpdated(customer.getUpdated());
        customerDTO.setRole(customer.getRole());
        return customerDTO;
    }



    public LoginDTO convertToLginDTO(EshopUser customer){
        LoginDTO customerDTO = new LoginDTO();
        customerDTO.setUserName(customer.getUserName());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setMessage("Success");
        return customerDTO;
    }



}
