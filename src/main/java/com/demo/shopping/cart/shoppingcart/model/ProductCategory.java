package com.demo.shopping.cart.shoppingcart.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Getter
@Setter
public class ProductCategory {
    @Id
    @GeneratedValue
    private Integer categoryId;

    private String categoryName;

    @NaturalId
    private Integer categoryType;

    private Instant createTime;

    private Instant updateTime;
}
