package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable {


    protected String a;
    protected String itemType;
    protected int unitPrice;
    protected int amount;
    protected Seller s;
    protected int weight;

    public CatalogItem(String a, String itemType, int unitPrice, int amount, Seller s, int weight) {
        this.a = a;
        this.itemType = itemType;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.s = s;
        this.weight = weight;
    }

    public int unitCharge() {
        return unitPrice;
    }

    public abstract int unitVat();

    public abstract int commissionOn(int i);

    public void reserve(int i) throws OutOfStockException {
        if(i > amount)
            throw new OutOfStockException("Out Of Stock!");
        if(i <= 0)
            throw new IllegalArgumentException("Invalid Amount Entered!");
        amount -= i;
    }

    public int remaining() {
        return amount;
    }

    public CatalogItem get(int i) {
        return null;
    }

    public boolean returned() {
        return false;
    }

    public String getItemType() {
        return itemType;
    }
}
