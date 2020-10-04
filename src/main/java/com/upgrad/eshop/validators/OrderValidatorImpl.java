package com.upgrad.eshop.validators;

import com.upgrad.eshop.dtos.EshopOrderDto;
import com.upgrad.eshop.exceptions.APIException;
import org.springframework.stereotype.Service;

@Service
public class OrderValidatorImpl implements OrderValidator {
    @Override
    public void validateOrder(EshopOrderDto eshopOrderDto) throws APIException {
        if(eshopOrderDto.getAddressId()<0)
            throw new APIException("Invalid address Id");
        if(eshopOrderDto.getProductId() <0)
            throw new APIException("Invalid product Id");
    }
}
