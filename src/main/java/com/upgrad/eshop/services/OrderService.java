package com.upgrad.eshop.services;

import com.upgrad.eshop.entities.EshopOrder;

import java.util.List;

public interface OrderService {
    EshopOrder createOrder(EshopOrder order);
    List<EshopOrder> getOrders();
}
