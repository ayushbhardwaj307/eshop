package com.upgrad.eshop.services;

import com.upgrad.eshop.entities.EshopProduct;
import com.upgrad.eshop.exceptions.ProductDetailsNotFound;

import java.util.List;

public interface ProductService {
    EshopProduct saveProduct(EshopProduct product);
    List<String> getProductCategories() throws ProductDetailsNotFound;
    EshopProduct getProductDetailsByGet(String category,String name) throws ProductDetailsNotFound;
    EshopProduct getProductDetailsById(int id) throws ProductDetailsNotFound;
    void deleteProduct(EshopProduct product);
    double getProductAmountById(int id) throws ProductDetailsNotFound ;
}
