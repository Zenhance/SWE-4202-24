package kenakata.catalog;

public class FreshGood extends CatalogItem {
    private double weight;

    public FreshGood(String SKU, String title, double unitPrice, int stockCount, Seller seller, double weight) {
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
}
