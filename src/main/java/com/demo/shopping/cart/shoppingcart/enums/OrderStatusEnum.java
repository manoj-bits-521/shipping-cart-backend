package com.demo.shopping.cart.shoppingcart.enums;


public enum OrderStatusEnum implements CodeEnum {
    NEW(0, "New OrderMain"),
    FINISHED(1, "Finished"),
    CANCELED(2, "Canceled");

    private final int code;
    private final String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
