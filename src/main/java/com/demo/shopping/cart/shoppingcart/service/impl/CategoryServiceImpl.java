package com.demo.shopping.cart.shoppingcart.service.impl;


import com.demo.shopping.cart.shoppingcart.domain.ProductCategory;
import com.demo.shopping.cart.shoppingcart.enums.ResultEnum;
import com.demo.shopping.cart.shoppingcart.util.exception.MyException;
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
        List<ProductCategory> res = productCategoryRepository.findAllByOrderByCategoryType();
        //  res.sort(Comparator.comparing(ProductCategory::getCategoryType));
        return res;
    }

    @Override
    public ProductCategory findByCategoryType(Integer categoryType) {
        ProductCategory res = productCategoryRepository.findByCategoryType(categoryType);
        if (res == null) throw new MyException(ResultEnum.CATEGORY_NOT_FOUND);
        return res;
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        List<ProductCategory> res = productCategoryRepository.findByCategoryTypeInOrderByCategoryTypeAsc(categoryTypeList);
        //res.sort(Comparator.comparing(ProductCategory::getCategoryType));
        return res;
    }

    @Override
    @Transactional
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }


}
