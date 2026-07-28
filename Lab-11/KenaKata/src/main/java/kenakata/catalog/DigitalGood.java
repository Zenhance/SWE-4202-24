package kenakata.catalog;

public class DigitalGood extends CatalogueItems{

    public DigitalGood(String sku, String title, int unit_price, int stock_count, Seller seller) {
        super(sku, title, unit_price, stock_count, seller);
    }

    @Override
    public boolean isShippable() {
        return false;
    }

    @Override
    public boolean canBeReturned() {
        return false;
    }

    @Override
    public double commission() {}

    @Override
    public double VAT() {}

}
