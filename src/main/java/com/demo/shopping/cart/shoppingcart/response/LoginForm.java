package com.demo.shopping.cart.shoppingcart.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@Data
public class LoginForm {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
