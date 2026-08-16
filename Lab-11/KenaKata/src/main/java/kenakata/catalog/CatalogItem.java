package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable {

    private String sku;
    private String title;
    private long unitPrice;
    private int stock;
    private Seller seller;
    private int reservedStock;

    public CatalogItem(String sku, String title, long unitPrice,int stock, Seller seller)  {
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("sku is required");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title is required");
        }
        if (unitPrice < 0) {
            throw new IllegalArgumentException("unitPrice can't be negative");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("stock can't be negative");
        }
        if(seller == null) {
            throw new IllegalArgumentException("seller is required");
        }
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.seller = seller;
        this.stock = stock;
    }

    public String getSku() {
        return sku;
    }

    public String getTitle() {
        return title;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public int getStock() {
        return stock;
    }
    public void reserve(int qty) throws Exception {
        if(qty <= 0){
            throw new IllegalArgumentException("qty must be positive");
        }
        if(qty > getStock()) {
            throw new OutOfStockException("Not enough stock to be reserved.");
        }
        this.stock -= qty;
        this.reservedStock += qty;
    }
    public int remaining() {
        return getStock();
    }


}
