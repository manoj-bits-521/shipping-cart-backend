package com.demo.shopping.cart.shoppingcart.service;

import com.demo.shopping.cart.shoppingcart.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<Products> findAll(Pageable pageable);

    Products findOne(String productId);

    Page<Products> findUpAll(Pageable pageable);

    Page<Products> findAllInCategory(Integer categoryType, Pageable pageable);

    void increaseStock(String productId, int amount);

    void decreaseStock(String productId, int amount);

    Products offSale(String productId);

    Products onSale(String productId);

    Products update(Products productInfo);

    Products save(Products productInfo);

    void delete(String productId);

}
