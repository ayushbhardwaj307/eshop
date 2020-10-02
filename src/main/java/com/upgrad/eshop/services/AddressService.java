package com.upgrad.eshop.services;

import com.upgrad.eshop.entities.EshopShippingAddress;

public interface AddressService {
    EshopShippingAddress createAddress(EshopShippingAddress address);
}
