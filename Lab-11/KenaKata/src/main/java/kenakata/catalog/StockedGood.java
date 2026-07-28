package kenakata.catalog;

public class StockedGood extends CatalogueItems{

    public int weight;
    public int quantity;
    private final static double VAT_RATE = (7.5/100);
    private final static double COMMISSION = (8/100);

    public StockedGood(String sku, String title, int unit_price, int stock_count, Seller seller, int weight) {
        super(sku, title, unit_price, stock_count, seller);
        this.weight = weight;
    }

    public StockedGood(String sku, String title, int unit_price, int stock_count, Seller seller, int weight, int quantity) {
        super(sku, title, unit_price, stock_count, seller);
        this.weight = weight;
        this.quantity = quantity;
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
        return (unit_price * quantity) * COMMISSION;
    }

    @Override
    public double VAT() {
        return Math.ceil(unit_price * VAT_RATE) * quantity;
    }
}
