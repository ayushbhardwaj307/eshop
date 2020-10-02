package com.upgrad.eshop.validators;

import com.upgrad.eshop.dtos.EshopShippingAddressDto;
import com.upgrad.eshop.exceptions.APIException;

public interface AddressValidator {
    void validateAddress(EshopShippingAddressDto addressDto) throws APIException;

}
