package com.demo.shopping.cart.shoppingcart.repo;

import com.demo.shopping.cart.shoppingcart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart, Integer> {
}
