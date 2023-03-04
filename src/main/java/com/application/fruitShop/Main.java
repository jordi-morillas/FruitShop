package com.application.fruitShop;

public class Main {
    static FruitShop fruitShop;
    public static void main(String[] args) {
        fruitShop = new FruitShop(args);
        fruitShop.mainProgram();
    }
}