package kenakata.catalog;

import kenakata.exceptions.OutofStockException;

public abstract class CatalogItem implements Chargeable{
    private final String sku;
    private final String name;
    private final long unitPrice;
    private final Seller seller;
    private int stock;
    protected CatalogItem(String sku, String name, long unitPrice, int stock, Seller seller) {
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU must not be blank!");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank!");
        }
        if (unitPrice < 0) {
            throw new IllegalArgumentException("Unit price must be greater than 0!");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Stock must be greater than 0!");
        }
        if (seller == null) {
            throw new IllegalArgumentException("Seller must not be null!");
        }

        this.sku = sku;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock= stock;
        this.seller = seller;

    }
    public String getSku(){
        return sku;
    }
    public String getName(){
        return name;
    }
    public long getUnitPrice(){
        return unitPrice;
    }
    public Seller getSeller(){
        return seller;
    }
    public int getStock(){
        return stock;
    }


    public long unitCharge(){
        return unitPrice;
    }

    public abstract long unitVat();


    public abstract long commissionOn(long i);

    public void reserve(int amount) throws OutofStockException {
        if(amount<=0){
            throw new IllegalArgumentException("Amount should be more than 0!");
        }
        if(amount>stock){
            throw new OutofStockException("Amount is out of stock!");
        }


    }
}
