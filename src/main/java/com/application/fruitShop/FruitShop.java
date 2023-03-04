package com.application.fruitShop;

import com.application.fruitShop.fileMapping.impl.ProductPriceList;
import com.application.fruitShop.fileMapping.impl.PurchaseOrderList;
import com.application.fruitShop.receipt.ReceiptManager;

public class FruitShop {
    String[] entryFiles;

    ProductPriceList productPriceList;
    PurchaseOrderList purchaseOrderList;
    ReceiptManager receiptManager;
    public FruitShop(String[] args){
        entryFiles = args;
    }

    protected void mainProgram() {
        this.validation();
        this.initializeData();
        this.printReceipt();
    }

    private void validation() {
        if(this.entryFiles.length != 2){
            throw new RuntimeException("Please send 2 valid file paths as an args");
        }

    }
    private void initializeData() {
        productPriceList = new ProductPriceList(entryFiles[0]);
        purchaseOrderList = new PurchaseOrderList(entryFiles[1]);
        receiptManager = new ReceiptManager(productPriceList, purchaseOrderList);

    }

    private void printReceipt() {
        receiptManager.printReceipt();
    }
}
