package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable {

    public boolean insured = false;
    protected String a;
    protected String itemType;
    protected int unitPrice;
    protected int amount;
    protected Seller s;
    protected int weight;
    protected boolean returned = false;

    public CatalogItem(String a, String itemType, int unitPrice, int amount, Seller s, int weight) {
        if(a == null || itemType == null || s == null || a.isBlank() || itemType.isBlank() || amount < 0 || unitPrice < 0 || weight <= 0)
            throw new IllegalArgumentException("Wrong input");
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



    public boolean returned() {
        return returned;
    }

    public String getItemType() {
        return itemType;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isReturned() {
        return returned;
    }

    public Seller getS() {
        return s;
    }
}
