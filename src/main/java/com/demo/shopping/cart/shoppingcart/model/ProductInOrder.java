package com.demo.shopping.cart.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class ProductInOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private OrderMain orderMain;


    @NotEmpty
    private String productId;

    @NotEmpty
    private String productName;


    @NotNull
    private String productDescription;

    private byte[] productIcon;


    @NotNull
    private Integer categoryType;

    @NotNull
    private BigDecimal productPrice;

    @Min(0)
    private Integer productStock;

    @Min(1)
    private Integer count;

    public ProductInOrder(Products productInfo, Integer quantity) {
        this.productId = productInfo.getId();
        this.productName = productInfo.getName();
        this.productDescription = productInfo.getDesc();
        this.productIcon = productInfo.getData();
        this.categoryType = productInfo.getCategory();
        this.productPrice = productInfo.getPrice();
        this.productStock = productInfo.getProductStock();
        this.count = quantity;
    }

}
