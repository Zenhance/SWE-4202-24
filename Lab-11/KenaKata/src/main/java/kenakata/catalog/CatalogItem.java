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
    public boolean isWeighable() {
        return Chargeable.super.isWeighable();
    }

    @Override
    public boolean returnable() {
        return Chargeable.super.returnable();
    }

    @Override
    public boolean insurable() {
        return Chargeable.super.insurable();
    }

    @Override
    public int returnDays() {
        return Chargeable.super.returnDays();
    }

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    public abstract long commissionOn(long i);

    @Override
    public double weight() {
        return Chargeable.super.weight();
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

    @Override
    public boolean isColdchain() {
        return Chargeable.super.isColdchain();
    }
}

