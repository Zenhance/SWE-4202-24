package kenakata.catalog;

public class DigitalGood extends LineItem {
    public DigitalGood(String sku, String title, long price, int count, Seller seller) {
        super(sku, title, price, count, seller);
    }
    
    @Override
    public long unitVat() {
        return (long)Math.ceil((double)unitCharge()*0.05);
    }
    @Override
    public double commissionOn(long price) {
        return Math.ceil((double)price*0.08);
    }
    
}
