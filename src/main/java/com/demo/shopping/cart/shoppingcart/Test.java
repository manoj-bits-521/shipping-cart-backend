package com.demo.shopping.cart.shoppingcart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test {
    public static void main(String[] args) throws IOException {
        byte[] bytes = Files.readAllBytes(Path.of("/Users/manojswasaka/Desktop/laptop2.jpg"));
        for (byte aByte : bytes) {
            System.out.print(aByte);
        }
    }
}
