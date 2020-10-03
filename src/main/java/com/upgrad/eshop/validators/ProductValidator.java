package com.upgrad.eshop.validators;

import com.upgrad.eshop.dtos.EshopProductDto;
import com.upgrad.eshop.exceptions.APIException;

public interface ProductValidator {
    void validateProduct(EshopProductDto productDto) throws APIException;
}
