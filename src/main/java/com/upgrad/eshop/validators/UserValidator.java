package com.upgrad.eshop.validators;

import com.upgrad.eshop.dtos.EshopUserDto;
import com.upgrad.eshop.dtos.LoginDTO;
import com.upgrad.eshop.exceptions.APIException;

public interface UserValidator {
    void validateUser(EshopUserDto userDto) throws APIException;
    void validateuserLogin(LoginDTO loginDTO) throws APIException;

}
