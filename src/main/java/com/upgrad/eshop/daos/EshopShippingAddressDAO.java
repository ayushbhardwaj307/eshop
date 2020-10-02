package com.upgrad.eshop.daos;

import com.upgrad.eshop.entities.EshopShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("eshopShippingDAO")
public interface EshopShippingAddressDAO extends JpaRepository<EshopShippingAddress,Integer> {
}
