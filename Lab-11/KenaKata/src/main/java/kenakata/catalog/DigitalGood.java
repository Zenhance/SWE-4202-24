package kenakata.catalog;

public class DigitalGood extends CatalogItem{
    public DigitalGood(String sku, String title, double unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
    }
    @Override
    public int unitCharge() {
        return 0;
    }

    @Override
    public int unitVat() {
        return (int) Math.ceil(getUnitPrice()*0.05);
    }

    @Override
    public int commissionOn(int total) {
        return (int) Math.ceil(total*0.2);
    }


}
