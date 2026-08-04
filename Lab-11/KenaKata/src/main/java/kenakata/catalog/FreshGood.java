package kenakata.catalog;

import kenakata.exceptions.NotInsurableException;

public class FreshGood extends CatalogItem implements Weighable, Insurable {
    private int weight;

    public FreshGood(String SKU, String title, double unitPrice, int stockCount, Seller seller, int weight) {
        super(SKU, title, unitPrice, stockCount, seller);
        if (weight <= 0.0)
            throw new IllegalArgumentException("Weight cannot be negative or zero");
        this.weight = weight;
    }

    @Override
    public int unitCharge() {
        return (int) Math.ceil(getUnitPrice());
    }

    @Override
    public int unitVat() {
        return (int) Math.ceil(getUnitPrice() * 0.00);
    }

    @Override
    public int commissionOn(int something) {
        return (int) Math.ceil(something * 0.05);
    }

    @Override
    public boolean returned() {
        return false;
    }

    @Override
    public int weight() {
        return weight;
    }

    @Override
    public int insurance() {
        return (int) Math.ceil(getUnitPrice() * 0.01);
    }

    @Override
    public void insure() throws NotInsurableException {
        super.insure();
    }
}
