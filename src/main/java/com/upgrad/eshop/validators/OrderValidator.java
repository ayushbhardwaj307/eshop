package com.upgrad.eshop.validators;

import com.upgrad.eshop.dtos.EshopOrderDto;
import com.upgrad.eshop.exceptions.APIException;

public interface OrderValidator {
    void validateOrder(EshopOrderDto eshopOrderDto) throws APIException;
}
