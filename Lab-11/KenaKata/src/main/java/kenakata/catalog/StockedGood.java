package kenakata.catalog;

import kenakata.exceptions.NotInsurableException;

public class StockedGood extends CatalogItem implements Weighable, Insurable{
    private int weight;

    public StockedGood(String SKU, String title, double unitPrice, int stockCount, Seller seller, int weight) {
        super(SKU, title, unitPrice, stockCount, seller);
        if (weight <= 0)
            throw new IllegalArgumentException("Weight cannot be negative or zero");
        this.weight = weight;
    }

    @Override
    public int unitCharge() {
        return (int) Math.ceil(getUnitPrice());
    }

    @Override
    public int unitVat() {
        return (int) Math.ceil(getUnitPrice() * 0.075);
    }

    // fix parameter
    @Override
    public int commissionOn(int something) {
        return (int) Math.ceil(something * 0.08);
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
        if (isInsured())
            return (int) Math.ceil(getUnitPrice() * 0.01);
        return 0;
    }

    @Override
    public void insure() throws NotInsurableException {
        super.insure();
    }
}
