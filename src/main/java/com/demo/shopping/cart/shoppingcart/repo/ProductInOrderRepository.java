package com.demo.shopping.cart.shoppingcart.repo;

import com.demo.shopping.cart.shoppingcart.model.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {

}
