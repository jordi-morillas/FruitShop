package com.application.fruitShop.fileMapping.impl;

import com.application.fruitShop.fileMapping.AbstractProductList;

import java.util.Map;

public class ProductPriceList extends AbstractProductList<Float> {
    public ProductPriceList(String filePath) {
        super(filePath);
    }

    @Override
    public void mapToValue(String value, Map<String, Float> map) {
        String[] splitEntry = value.split(",");
        getOrderItems().put(splitEntry[0], Float.parseFloat(splitEntry[1]));
    }

}
