package com.demo.shopping.cart.shoppingcart.repo;

import com.demo.shopping.cart.shoppingcart.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepo extends JpaRepository<Products, String> {

    Products findByProductId(String id);

    Page<Products> findAllByProductStatusOrderByIdAsc(Integer productStatus, Pageable pageable);

    Page<Products> findAllByCategoryTypeOrderByIdAsc(Integer categoryType, Pageable pageable);

    Page<Products> findAllByOrderById(Pageable pageable);

}
