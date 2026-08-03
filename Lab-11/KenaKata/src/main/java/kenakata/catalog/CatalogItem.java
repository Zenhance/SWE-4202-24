package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable {
    private final String sku;
    private final String title;
    private final long unitPrice;
    private int liveStock;
    private final Seller seller;

    public CatalogItem(String sku, String title, long unitPrice, int liveStock, Seller seller) {
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.liveStock = liveStock;
        this.seller = seller;
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

    public int getLiveStock() {
        return liveStock;
    }

    public Seller getSeller() {
        return seller;
    }

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    public abstract long commissionOn(int i);

    public double weight() {
        return 0;
    }
    public void reserve(int quantity) throws OutOfStockException {
        if(quantity>liveStock){
        throw new OutOfStockException("Please enter different value");
        }
        liveStock = liveStock-quantity;
    }
    public int remaining(){
        return liveStock;
    }
}

