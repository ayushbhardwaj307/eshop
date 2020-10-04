package com.upgrad.eshop.daos;

import com.upgrad.eshop.entities.EshopShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("eshopShippingDAO")
public interface EshopShippingAddressDAO extends JpaRepository<EshopShippingAddress,Integer> {
    Optional<EshopShippingAddress> findById(int id);
}

