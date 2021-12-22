package com.demo.shopping.cart.shoppingcart.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String account;
    private String name;
    private String role;

    public JwtResponse(String token, String account, String name, String role) {
        this.account = account;
        this.name = name;
        this.token = token;
        this.role = role;
    }
}
