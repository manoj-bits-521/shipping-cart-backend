package com.demo.shopping.cart.shoppingcart.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Setter
@Getter
public class Products {
    @Id
    @Column(name = "product_id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String desc;
    @Column(name = "price")
    private BigDecimal price;
    @NotNull
    @Min(0)
    private Integer productStock;
    @Column(name = "picture")
    @Lob
    private byte[] data;
    @ColumnDefault("0")
    @Column(name = "category")
    private Integer category;
    @ColumnDefault("0")
    private Integer productStatus;
    @CreationTimestamp
    private Instant createTime;
    @UpdateTimestamp
    private Instant updateTime;
}
