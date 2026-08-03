package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem{
    private final String sku;
    private final String title;
    private final long unitPrice;
    private int stock;
    private final Seller seller;

    public CatalogItem(String sku, String title, long unitPrice, int stock, Seller seller){
        if (sku == null || sku.isBlank() || title == null || title.isBlank() || seller == null){
            throw new IllegalArgumentException("SKU, title, and seller must not be null.");
        }
        if (unitPrice < 0 || stock < 0){
            throw new IllegalArgumentException("Price and stock cannot be negative.");
        }
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.seller = seller;
    }

    public String getSku(){
        return sku;}
    public String getTitle(){
        return title;}
    public long getUnitPrice(){
        return unitPrice;}
    public int getStock(){
        return stock;}
    public Seller getSeller(){
        return seller;}

    public void reserve(int quantity) throws OutOfStockException{
        if (quantity <= 0){
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        if (this.stock < quantity){
            throw new OutOfStockException("Insufficient stock for item: " + title);
        }
        this.stock -= quantity;
    }

    public void releaseStock(int quantity){
        this.stock += quantity;
    }

    public abstract long getVatPerUnit();
    public abstract double getCommissionRate();

    public boolean hasWeight(){
        return false; }
    public int getWeightGramsPerUnit(){
        return 0; }
    public boolean isColdChain(){
        return false; }
    public boolean isInsurable(){
        return false; }
    public boolean isReturnable(){
        return false; }
}