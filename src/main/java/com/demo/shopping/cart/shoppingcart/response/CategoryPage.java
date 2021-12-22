package com.demo.shopping.cart.shoppingcart.response;

import com.demo.shopping.cart.shoppingcart.model.Products;
import org.springframework.data.domain.Page;


public class CategoryPage {
    private String category;
    private Page<Products> page;

    public CategoryPage(String category, Page<Products> page) {
        this.category = category;
        this.page = page;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Page<Products> getPage() {
        return page;
    }

    public void setPage(Page<Products> page) {
        this.page = page;
    }
}
