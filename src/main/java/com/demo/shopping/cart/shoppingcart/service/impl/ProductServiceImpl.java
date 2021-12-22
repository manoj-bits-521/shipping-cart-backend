package com.demo.shopping.cart.shoppingcart.service.impl;

import com.demo.shopping.cart.shoppingcart.dto.ProductStatusEnum;
import com.demo.shopping.cart.shoppingcart.dto.ResultEnum;
import com.demo.shopping.cart.shoppingcart.model.Products;
import com.demo.shopping.cart.shoppingcart.repo.ProductDetailsRepo;
import com.demo.shopping.cart.shoppingcart.service.CategoryService;
import com.demo.shopping.cart.shoppingcart.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDetailsRepo productDetailsRepo;

    @Autowired
    CategoryService categoryService;

    @Override
    public Page<Products> findAll(Pageable pageable) {
        return productDetailsRepo.findAllByOrderById(pageable);
    }

    @Override
    public Products findOne(String productId) {
        return  productDetailsRepo.findByProductId(productId);
    }

    @Override
    public Page<Products> findUpAll(Pageable pageable) {
        return productDetailsRepo.findAllByProductStatusOrderByIdAsc(ProductStatusEnum.UP.getCode(),pageable);
    }

    @Override
    public Page<Products> findAllInCategory(Integer categoryType, Pageable pageable) {
        return productDetailsRepo.findAllByCategoryTypeOrderByIdAsc(categoryType, pageable);
    }
    @Override
    @Transactional
    public void increaseStock(String productId, int amount) {
        Products productInfo = findOne(productId);
        if (productInfo == null) throw new MyException(ResultEnum.PRODUCT_NOT_EXIST);

        int update = productInfo.getProductStock() + amount;
        productInfo.setProductStock(update);
        productDetailsRepo.save(productInfo);
    }

    @Override
    @Transactional
    public void decreaseStock(String productId, int amount) {
        Products productInfo = findOne(productId);
        if (productInfo == null) throw new MyException(ResultEnum.PRODUCT_NOT_EXIST);

        int update = productInfo.getProductStock() - amount;
        if(update <= 0) throw new MyException(ResultEnum.PRODUCT_NOT_ENOUGH );

        productInfo.setProductStock(update);
        productDetailsRepo.save(productInfo);
    }

    @Override
    @Transactional
    public Products offSale(String productId) {
        Products productInfo = findOne(productId);
        if (productInfo == null) throw new MyException(ResultEnum.PRODUCT_NOT_EXIST);

        if (productInfo.getProductStatus() == ProductStatusEnum.DOWN.getCode()) {
            throw new MyException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return productDetailsRepo.save(productInfo);
    }

    @Override
    @Transactional
    public Products onSale(String productId) {
        Products productInfo = findOne(productId);
        if (productInfo == null) throw new MyException(ResultEnum.PRODUCT_NOT_EXIST);

        if (productInfo.getProductStatus() == ProductStatusEnum.UP.getCode()) {
            throw new MyException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return productDetailsRepo.save(productInfo);
    }

    @Override
    public Products update(Products productInfo) {
        categoryService.findByCategoryType(productInfo.getCategory());
        if(productInfo.getProductStatus() > 1) {
            throw new MyException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        return productDetailsRepo.save(productInfo);
    }

    @Override
    public Products save(Products productInfo) {
        return update(productInfo);
    }

    @Override
    public void delete(String productId) {
        Products productInfo = findOne(productId);
        if (productInfo == null) throw new MyException(ResultEnum.PRODUCT_NOT_EXIST);
        productDetailsRepo.delete(productInfo);

    }
}
