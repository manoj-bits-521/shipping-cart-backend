package com.demo.shopping.cart.shoppingcart.service;

import com.demo.shopping.cart.shoppingcart.model.Cart;
import com.demo.shopping.cart.shoppingcart.model.ProductInOrder;
import com.demo.shopping.cart.shoppingcart.model.User;

import java.util.Collection;

public interface CartService {
    Cart getCart(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}
