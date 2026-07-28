package kenakata.catalog;

public class DigitalGood extends CatalogueItems{

    public int quantity;
    private final static double VAT_RATE = (5/100);
    private static final double COMMISION = 0.5;

    public DigitalGood(String sku, String title, int unit_price, int stock_count, Seller seller) {
        super(sku, title, unit_price, stock_count, seller);
    }

    public DigitalGood(String sku, String title, int unit_price, int stock_count, Seller seller, int quantity) {
        super(sku, title, unit_price, stock_count, seller);
        this.quantity = quantity;
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
    public double commission() {
        return (unit_price * quantity) * COMMISION;
    }

    @Override
    public double VAT() {
        return (unit_price * quantity) * VAT_RATE;
    }

}
