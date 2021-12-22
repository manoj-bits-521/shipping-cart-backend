package com.demo.shopping.cart.shoppingcart.service;


import com.demo.shopping.cart.shoppingcart.model.ProductInOrder;
import com.demo.shopping.cart.shoppingcart.model.User;

public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);

    ProductInOrder findOne(String itemId, User user);
}
