package kenakata.catalog;

public class FreshGood extends CatalogueItems{

    public int weight;

    public FreshGood(String sku, String title, int unit_price, int stock_count, Seller seller,  int weight) {
        super(sku, title, unit_price, stock_count, seller);
        this.weight = weight;
    }

    @Override
    public boolean isShipplable() {
        return true;
    }

    @Override
    public boolean canBeReturned() {
        return true;
    }

    @Override
    public double commission() {}
}
