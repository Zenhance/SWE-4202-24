package kenakata.catalog;

public class DigitalGood extends CatalogItem{
    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(unitPrice()*0.05);
    }

    @Override
    public long commissionOn(long lineValue) {
        return 0;
    }

    @Override
    public int commissionOn(int total) {
        return (int) Math.ceil(total*0.2);
    }


}
