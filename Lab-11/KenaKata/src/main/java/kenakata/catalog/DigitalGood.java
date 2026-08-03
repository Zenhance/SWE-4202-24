package kenakata.catalog;

public class DigitalGood {
    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
    }
    @Override
    public long unitVat() {
        return (long) Math.ceil(unitCharge() * 0.05); // 5% VAT
    }
    @Override
    public long commissionOn(long amount) {
        return (long) Math.ceil(amount * 0.20); // 20% commission
    }
}
