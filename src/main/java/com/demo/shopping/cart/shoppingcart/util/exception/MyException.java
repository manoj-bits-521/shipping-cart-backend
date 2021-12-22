package com.demo.shopping.cart.shoppingcart.util.exception;


import com.demo.shopping.cart.shoppingcart.enums.ResultEnum;


public class MyException extends RuntimeException {

    private final Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
