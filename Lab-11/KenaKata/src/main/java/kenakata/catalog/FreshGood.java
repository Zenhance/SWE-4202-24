package kenakata.catalog;

public class FreshGood extends CatalogueItems{

    public int weight;
    public int quantity;
    private static final double COMMISION = 0.05;

    public FreshGood(String sku, String title, int unit_price, int stock_count, Seller seller,  int weight) {
        super(sku, title, unit_price, stock_count, seller);
        this.weight = weight;
        this.quantity = quantity;
    }

//    @Override
    ////    public boolean isShippable() {
    ////        return false;
    ////    }
    ////
    ////    @Override
    ////    public boolean canBeReturned() {
    ////        return true;
    ////    }

    @Override
    public double unitVat() {
        return 0;
    }

    @Override
    public double commissionOn(int unit_price) {
        return unit_price * COMMISION;
    }
}
