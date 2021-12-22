package com.demo.shopping.cart.shoppingcart.service;


import com.demo.shopping.cart.shoppingcart.model.User;

import java.util.Collection;


public interface UserService {
    User findOne(String email);

    Collection<User> findByRole(String role);

    User save(User user);

    User update(User user);
}
