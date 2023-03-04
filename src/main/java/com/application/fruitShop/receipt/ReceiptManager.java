package com.application.fruitShop.receipt;

import com.application.fruitShop.fileMapping.impl.ProductPriceList;
import com.application.fruitShop.fileMapping.impl.PurchaseOrderList;

import java.util.Map;

public class ReceiptManager {
    private final int NUMBER_OF_LINE_SEPARATORS = 15;
    ProductPriceList priceList;
    PurchaseOrderList purchaseOrderList;
    public ReceiptManager(ProductPriceList productPriceList, PurchaseOrderList purchaseOrderList){
        this.priceList = productPriceList;
        this.purchaseOrderList = purchaseOrderList;
    }

    public void printReceipt() {
        StringBuilder output = new StringBuilder();
        // Printing elements on list of purchased items
        output.append("List of products purchased\n");
        output.append("-".repeat(NUMBER_OF_LINE_SEPARATORS)).append("\n");

        // Printing price list
        output.append("Product\t").append("Quantity\t").append("Unit price\t").append("\n");
        for (Map.Entry<String, Integer> entry : purchaseOrderList.getOrderItems().entrySet()) {
            output.append(entry.getKey()).append("\t")
                    .append(entry.getValue()).append("\t".repeat(3))
                    .append(priceList.getOrderItems().get(entry.getKey())).append("\t\n");
        }

        // Printing price amount
        output.append("-".repeat(NUMBER_OF_LINE_SEPARATORS)).append("\n");
        output.append("Total price:\t").append(calculateTotalPrice());

        System.out.println(output);

    }

    private float calculateTotalPrice() {
        float totalPrice = 0;
        for (Map.Entry<String, Integer> entry : purchaseOrderList.getOrderItems().entrySet()) {
            totalPrice += priceList.getOrderItems().get(entry.getKey()) * entry.getValue();
        }
        return totalPrice;
    }
}
