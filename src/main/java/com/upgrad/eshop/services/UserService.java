package com.upgrad.eshop.services;

import com.upgrad.eshop.entities.EshopUser;
import com.upgrad.eshop.exceptions.UserAlreadyExistsException;
import com.upgrad.eshop.exceptions.UserDetailsNotfoundException;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    EshopUser createUser(EshopUser users) throws UserAlreadyExistsException;
    EshopUser getUser(String emailid, String password) throws UserDetailsNotfoundException;
    EshopUser getCustomerDetailsByEmail(String email) throws UserDetailsNotfoundException;
    EshopUser getCustomerDetailsByUserName(String username) throws UserDetailsNotfoundException;
    UserDetails loadCustomerDetails(String username) throws UserDetailsNotfoundException;
    EshopUser getUserDetails(int id) throws UserDetailsNotfoundException;
    public EshopUser getCustomerDetailsById(int id) throws UserDetailsNotfoundException;
}
