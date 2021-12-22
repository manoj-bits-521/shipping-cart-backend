package com.demo.shopping.cart.shoppingcart.controller;

import com.demo.shopping.cart.shoppingcart.domain.ProductInfo;
import com.demo.shopping.cart.shoppingcart.service.CategoryService;
import com.demo.shopping.cart.shoppingcart.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/getAllProducts")
    public Page<ProductInfo> getAllProducts(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                            @RequestParam(value = "size", defaultValue = "3") Integer size) {
        PageRequest request = PageRequest.of(page - 1, size);
        return productService.findAll(request);
    }

    @GetMapping("/getProduct/{id}")
    public ProductInfo getProduct(@PathVariable String id) {
        return productService.findOne(id);
    }

    @PostMapping(value = "/addProduct", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addProduct(@RequestParam("file") MultipartFile file, ProductInfo product) {
        ProductInfo productIdExists = productService.findOne(product.getProductId());
        ProductInfo newProduct = new ProductInfo();
        if (product != null) {
            if (productIdExists != null) {
                return "Product already exists";
            } else {
                try {
                    BeanUtils.copyProperties(product, newProduct);
                    newProduct.setProductIcon(file.getBytes());
                    productService.save(product);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "Product added Successfully";
            }
        } else {
            return "not a valid request";
        }
    }

    @DeleteMapping("/deleteProduct")
    public String deleteABook(@PathVariable String id) {
        try {
            productService.delete(id);
            return "successfully deleted";
        } catch (Exception e) {
            return "id not exists";
        }
    }

    @PutMapping("updateProduct/{id}")
    public String updateProduct(@PathVariable("id") String id, @RequestParam("file") MultipartFile file, ProductInfo product) {
        ProductInfo newProduct = new ProductInfo();
        if (!id.equals(product.getProductId())) {
            return "Id Not Matched";
        } else {
            try {
                BeanUtils.copyProperties(product, newProduct);
                newProduct.setProductIcon(file.getBytes());
                productService.save(product);
                return "successfully updated";
            } catch (IOException e) {
                e.printStackTrace();
                return "Id not available";
            }
        }
    }

}
