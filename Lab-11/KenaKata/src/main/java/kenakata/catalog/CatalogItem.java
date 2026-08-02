package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable{
    private final String sku;
    private final String title;
    private final long unitPrice;
    private int remainingStock;
    private final Seller seller;

    public CatalogItem(String sku,String title,long unitPrice, int initialStock, Seller seller) {
        if(sku==null || sku.trim().isEmpty()) throw new IllegalArgumentException();
        if(title==null || title.trim().isEmpty()) throw new IllegalArgumentException();
        if(unitPrice<0 || initialStock<0 || seller==null) throw new IllegalArgumentException();
        this.sku=sku;
        this.title=title;
        this.unitPrice=unitPrice;
        this.remainingStock=initialStock;
        this.seller=seller;
    }

    public String sku() {
        return sku;
    }

    public String title() {
        return title;
    }

    public long unitPrice() {
        return unitPrice;
    }

    public int remainingStock() {
        return remainingStock;
    }

    public Seller seller() {
        return seller;
    }

    public synchronized void reserve(int qty) throws OutOfStockException {
        if(qty<=0) throw new IllegalArgumentException();
        if(remainingStock<qty) throw new OutOfStockException("OUT OF STOCk");
        remainingStock -= qty;
    }

    public long unitCharge() {
        return unitPrice;
    }

    public String label() {
        return title;
    }

    public abstract long comissionOn(long linevalue);
    public Integer weightGrams() {
        return null;
    }

    public boolean isColdChain() {
        return false;
    }

    public boolean isInsurable() {
        return false;
    }

    public Integer returnWindowDays() {
        return null;
    }
}
