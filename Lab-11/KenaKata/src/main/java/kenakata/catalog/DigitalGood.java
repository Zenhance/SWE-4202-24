package kenakata.catalog;

public class DigitalGood extends CatalogItem {

    public DigitalGood(String sku, String title, long price, int stock, Seller seller) {
        super(sku, title, price, stock, seller);
    }

    @Override
    public long commissionOn(long lineValue) {
        return Math.round(lineValue*0.20);
    }
    @Override
    public long unitVat(){
        return Math.round(price * 0.05);
    }
}