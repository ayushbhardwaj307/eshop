package com.upgrad.eshop.services;

import com.upgrad.eshop.daos.EshopShippingAddressDAO;
import com.upgrad.eshop.entities.EshopShippingAddress;
import com.upgrad.eshop.exceptions.AddressNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("AddressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    @Qualifier("eshopShippingDAO")
    private EshopShippingAddressDAO addressDAO;

    @Override
    public EshopShippingAddress createAddress(EshopShippingAddress address) {
        return addressDAO.save(address);
    }

    @Override
    public EshopShippingAddress getAddressDetailsById(int id) throws AddressNotFound {
        return addressDAO.findById(id).orElseThrow(
                () -> new AddressNotFound("Address not found for " + id));
    }
}
