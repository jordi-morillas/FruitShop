package com.application.fruitShop.fileMapping.impl;

import com.application.fruitShop.fileMapping.AbstractProductList;

import java.util.Map;

public class PurchaseOrderList extends AbstractProductList<Integer> {

    public PurchaseOrderList(String filePath) {
        super(filePath);
    }
    @Override
    public void mapToValue(String value, Map<String, Integer> map) {
        String[] splitEntry = value.split(",");
        getOrderItems().put(splitEntry[0], Integer.parseInt(splitEntry[1].trim()));
    }
}
