package com.upgrad.eshop.services;

import com.upgrad.eshop.daos.EshopProductDAO;
import com.upgrad.eshop.entities.EshopProduct;
import com.upgrad.eshop.exceptions.ProductDetailsNotFound;
import com.upgrad.eshop.utils.EntityDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier("eshopProductDAO")
    private EshopProductDAO eshopProductDAO;

    @Autowired
    EntityDTOConverter entityDTOConverter;

    @Override
    public EshopProduct saveProduct(EshopProduct product) {
        return eshopProductDAO.save(product);
    }

    @Override
    public void deleteProduct(EshopProduct product) {
        eshopProductDAO.delete(product);
    }

    @Override
    public EshopProduct getProductDetailsByGet(String category,String name) throws ProductDetailsNotFound {
        EshopProduct product=new EshopProduct();
        if(category!=null) {
            product = eshopProductDAO.findByCategory(category).orElseThrow(
                    () -> new ProductDetailsNotFound("Product not found for " + category));
        }

        if(name!=null) {
            product = eshopProductDAO.findByCategory(name).orElseThrow(
                    () -> new ProductDetailsNotFound("Product not found for " + name));
        }
        return product;
    }

    @Override
    public EshopProduct getProductDetailsById(int id) throws ProductDetailsNotFound {
        return eshopProductDAO.findById(id).orElseThrow(
                () -> new ProductDetailsNotFound("Product not found for " + id));
    }

    public List<String> getProductCategories() throws ProductDetailsNotFound {
        List<EshopProduct> eshopProductList=eshopProductDAO.findAll();
        List<String> categories=new ArrayList<>();

        for(EshopProduct p:eshopProductList){
            categories.add(p.getCategory());
        }
        return categories;
    }

    @Override
    public double getProductAmountById(int id) throws ProductDetailsNotFound {
        EshopProduct product=eshopProductDAO.findById(id).orElseThrow(
                () -> new ProductDetailsNotFound("Product not found for " + id));
        return product.getPrice();
    }
}
