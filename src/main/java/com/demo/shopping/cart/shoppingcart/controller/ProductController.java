package com.demo.shopping.cart.shoppingcart.controller;

import com.demo.shopping.cart.shoppingcart.model.Products;
import com.demo.shopping.cart.shoppingcart.repo.ProductDetailsRepo;
import com.demo.shopping.cart.shoppingcart.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/shopping")
@Slf4j
public class ProductController {

    @Autowired
    ProductDetailsRepo productDetails;
    @Autowired
    ProductService productService;

    @GetMapping("/getAllProducts")
    public Page<Products> getAllProducts(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                         @RequestParam(value = "size", defaultValue = "3") Integer size) {
        PageRequest request = PageRequest.of(page - 1, size);
        return productService.findAll(request);
    }

    @GetMapping("/getProduct/{id}")
    public Products getProduct(@PathVariable String id) {
        return productService.findOne(id);
    }

    @PostMapping(value = "/addProduct", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addProduct(@RequestParam("file") MultipartFile file, Products product) {
        Products productIdExists = productService.findOne(product.getId());
        Products newProduct = new Products();
        if (product != null) {
            if (productIdExists != null) {
                return "Product already exists";
            } else {
                try {
                    BeanUtils.copyProperties(product, newProduct);
                    newProduct.setData(file.getBytes());
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
            log.error("Error occurred While deleting the product");
            return "id not exists";
        }
    }

    @PutMapping("updateProduct/{id}")
    public String updateProduct(@PathVariable("id") String id, @RequestParam("file") MultipartFile file, Products product) {
        Products newProduct = new Products();
        if (!id.equals(product.getId())) {
            return "Id Not Matched";
        } else {
            try {
                BeanUtils.copyProperties(product, newProduct);
                newProduct.setData(file.getBytes());
                productService.save(product);
                return "successfully updated";
            } catch (IOException e) {
                e.printStackTrace();
                return "Id not available";
            }
        }
    }


}
