package com.demo.shopping.cart.shoppingcart.service.impl;

import com.demo.shopping.cart.shoppingcart.dto.ResultEnum;
import com.demo.shopping.cart.shoppingcart.model.ProductCategory;
import com.demo.shopping.cart.shoppingcart.repo.ProductCategoryRepository;
import com.demo.shopping.cart.shoppingcart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;


    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAllByOrderByCategoryType();
    }

    @Override
    public ProductCategory findByCategoryType(Integer categoryType) {
        ProductCategory res = productCategoryRepository.findByCategoryType(categoryType);
        if (res == null) throw new MyException(ResultEnum.CATEGORY_NOT_FOUND);
        return res;
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeInOrderByCategoryTypeAsc(categoryTypeList);
    }

    @Override
    @Transactional
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
