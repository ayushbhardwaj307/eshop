package com.upgrad.eshop.daos;

import com.upgrad.eshop.entities.EshopUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("eshopUserDAO")
public interface EshopUserDAO extends JpaRepository<EshopUser,Integer> {
    Optional<EshopUser> findByEmail(String emailId);
    Optional<EshopUser> findByPassword(String password);
    Optional<EshopUser> findByUserName(String username);
    Optional<EshopUser> findById(int id);
}
