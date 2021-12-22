package com.demo.shopping.cart.shoppingcart.repo;

import com.demo.shopping.cart.shoppingcart.domain.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By Zhu Lin on 3/14/2018.
 */
public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {

}
