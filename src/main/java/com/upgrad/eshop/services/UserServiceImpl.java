package com.upgrad.eshop.services;

import com.upgrad.eshop.daos.EshopUserDAO;
import com.upgrad.eshop.entities.EshopUser;
import com.upgrad.eshop.exceptions.UserAlreadyExistsException;
import com.upgrad.eshop.exceptions.UserDetailsNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("eshopUserDAO")
    private EshopUserDAO usersDAO;

    @Override
    public EshopUser getUserDetails(int id) throws UserDetailsNotfoundException {
        EshopUser user =usersDAO.findById(id).orElseThrow(
                ()->  new UserDetailsNotfoundException("User not found for " + id));
        return user;
    }

    @Override
        public EshopUser createUser(EshopUser users) throws UserAlreadyExistsException {
            if(usersDAO.findByEmail(users.getEmail()).isPresent()) {
                throw new UserAlreadyExistsException("Email Already Exists");
            }
            return usersDAO.save(users);
        }

    @Override
    public EshopUser getUser(String emailid,String password) throws UserDetailsNotfoundException {
            
            if(!usersDAO.findByEmail(emailid).isPresent()) {
                throw new UserDetailsNotfoundException("User not Registered");
            }
            
            if(!usersDAO.findByPassword(password).isPresent()){
                throw new UserDetailsNotfoundException("Unauthorized User");
            }

        return usersDAO.findByEmail(emailid).get();
    }

    public EshopUser getCustomerDetailsByEmail(String email) throws UserDetailsNotfoundException {
        EshopUser customer = usersDAO.findByEmail(email).orElseThrow(
                ()->  new UserDetailsNotfoundException("User not found for email" + email));
        return customer;
    }

   public EshopUser getCustomerDetailsByUserName(String username) throws UserDetailsNotfoundException {
        EshopUser customer = usersDAO.findByUserName(username).orElseThrow(
                ()->  new UserDetailsNotfoundException("User not found for " + username));
        return customer;
    }

    @Override
    public UserDetails loadCustomerDetails(String username) throws UserDetailsNotfoundException {
        EshopUser user = usersDAO.findByUserName(username).orElseThrow(
                ()->  new UserDetailsNotfoundException("User not found for " + username));

        return  new User(user.getEmail(), user.getPassword() , new ArrayList<>());
    }

    public EshopUser getCustomerDetailsById(int id) throws UserDetailsNotfoundException {
        EshopUser customer = usersDAO.findById(id).orElseThrow(
                ()->  new UserDetailsNotfoundException("User not found for id" + id));
        return customer;
    }
}
