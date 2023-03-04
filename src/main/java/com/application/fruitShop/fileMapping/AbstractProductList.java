package com.application.fruitShop.fileMapping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class stores the data related to the purchase order
 */
public abstract class AbstractProductList<T> implements FileToHashMap<T> {

    private Map<String, T> orderItems;

    public AbstractProductList(String filePath){
        orderItems = new HashMap<>();
        initializeMap(filePath);
    }

    private void initializeMap(String filePath){
        try (BufferedReader buffer = new BufferedReader(new FileReader(filePath))){
            String line;
            boolean isFirstLine = true;
            while ((line = buffer.readLine()) != null) {
                if(isFirstLine){
                   isFirstLine = false;
                } else {
                    mapToValue(line, orderItems);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void printMapValues() {
        for (Map.Entry<String, T> entry : orderItems.entrySet()) {
            System.out.println("Product: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }

    public Map<String, T> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Map<String, T> orderItems) {
        this.orderItems = orderItems;
    }
}
