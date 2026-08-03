package kenakata.catalog;

public class DigitalGood extends Item {
    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
    }

    @Override public long unitVat() { return (long) Math.ceil(unitCharge() * 0.05); }
    @Override public long commissionOn(long totalCharge) { return (long) Math.ceil(totalCharge * 0.20); }
}