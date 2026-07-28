package kenakata.catalog;

public class StockedGood extends Good{
    private double weight;

    public StockedGood(String SKU, String title, double unitPrice, int stockCount, Seller seller, double weight) {
        super(SKU, title, unitPrice, stockCount, seller);
        this.weight = weight;
    }

    public int unitCharge() {
        return (int) Math.ceil(getUnitPrice());
    }

    public int unitVat() {
        return (int) Math.ceil(getUnitPrice() * 0.075);
    }

    // fix parameter
    public int commissionOn(int something) {
        return (int) Math.ceil(something * 0.08);
    }
}
