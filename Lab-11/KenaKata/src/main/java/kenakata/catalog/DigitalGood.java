package kenakata.catalog;

public class DigitalGood extends CatalogItem {
    public DigitalGood(String SKU, String title, double unitPrice, int stockCount, Seller seller) {
        super(SKU, title, unitPrice, stockCount, seller);
    }

    @Override
    public int unitCharge() {
        return (int) Math.ceil(getUnitPrice());
    }

    @Override
    public int unitVat() {
        return (int) Math.ceil(getUnitPrice() * 0.05);
    }

    @Override
    public int commissionOn(int something) {
        return (int) Math.ceil(something * 0.2);
    }

    @Override
    public boolean returned() {
        return false;
    }
}
