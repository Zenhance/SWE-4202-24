package kenakata.catalog;

public class StockedGood extends CatalogueItems{

    public int weight;

    public StockedGood(String sku, String title, int unit_price, int stock_count, Seller seller, int weight) {
        super(sku, title, unit_price, stock_count, seller);
        this.weight = weight;
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    @Override
    public boolean canBeReturned() {
        return true;
    }

    @Override
    public double commission() {

    }

    @Override
    public double VAT() {

    }
}
