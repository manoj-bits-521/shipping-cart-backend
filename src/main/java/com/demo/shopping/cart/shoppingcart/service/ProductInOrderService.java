package com.demo.shopping.cart.shoppingcart.service;

import com.demo.shopping.cart.shoppingcart.domain.ProductInOrder;
import com.demo.shopping.cart.shoppingcart.domain.User;


public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);

    ProductInOrder findOne(String itemId, User user);
}
