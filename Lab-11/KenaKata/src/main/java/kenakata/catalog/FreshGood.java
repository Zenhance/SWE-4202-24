package kenakata.catalog;

public class FreshGood extends CatalogueItems{

    public int weight;
    public int quantity;
    private static final double COMMISION = (5/100);

    public FreshGood(String sku, String title, int unit_price, int stock_count, Seller seller,  int weight) {
        super(sku, title, unit_price, stock_count, seller);
        this.weight = weight;
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
    public double commissionOn() {
        return (unit_price * quantity) * COMMISION;
    }

    @Override
    public double unitVat() {

    }
}
