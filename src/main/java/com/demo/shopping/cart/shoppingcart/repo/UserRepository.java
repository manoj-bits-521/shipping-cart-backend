package com.demo.shopping.cart.shoppingcart.repo;


import com.demo.shopping.cart.shoppingcart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;


public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);

    Collection<User> findAllByRole(String role);

}
