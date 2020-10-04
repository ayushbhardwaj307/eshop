package com.upgrad.eshop.services;

import com.upgrad.eshop.entities.EshopShippingAddress;
import com.upgrad.eshop.exceptions.AddressNotFound;

public interface AddressService {
    EshopShippingAddress createAddress(EshopShippingAddress address);
    EshopShippingAddress getAddressDetailsById(int id) throws AddressNotFound;
}
