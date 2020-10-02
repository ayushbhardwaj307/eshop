package com.upgrad.eshop.validators;

import com.upgrad.eshop.dtos.EshopUserDto;
import com.upgrad.eshop.dtos.LoginDTO;
import com.upgrad.eshop.exceptions.APIException;
import org.springframework.stereotype.Service;

@Service
public class UserValidatorImpl implements UserValidator {
    @Override
    public void validateUser(EshopUserDto userDto) throws APIException {
        if(userDto.getEmail() == null || userDto.getEmail().length() <= 0)
            throw new APIException("Invalid username");
        if(userDto.getFirstName() == null || userDto.getFirstName().length() <= 0 )
            throw new APIException("Invalid firstname");
        if(userDto.getLastName() == null || userDto.getLastName().length() <= 0 )
            throw new APIException("Invalid lastname");
        if(userDto.getPassword() == null || userDto.getPassword().length() <= 0   )
            throw new APIException("Invalid password");
        if(userDto.getPhoneNumber() == null || userDto.getPhoneNumber().length() <= 0   )
            throw new APIException("Invalid password");
    }

    public void validateuserLogin(LoginDTO user) throws APIException {
        if (user.getUserName() == null || user.getUserName().length() <= 0) {
            throw new APIException("Invalid username");
        }
        if(user.getPassword() == null || user.getPassword().length() <= 0   ) {
            throw new APIException("Invalid password");
        }
    }
}
