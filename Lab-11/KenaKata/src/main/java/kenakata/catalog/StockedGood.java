package kenakata.catalog;


public class StockedGood extends CatalogItem implements Weighable, Insurable, Returnable {
    private static final double VAT=0.075;
    private static final double COMISSION=8.0;

    public StockedGood(String SKU, String title, double UnitPrice, Seller seller, int Stock) {
        super(SKU, title, UnitPrice, seller, Stock);
    }



    @Override
    public double vatCharge() {
        return Math.ceil(unitCharge()*VAT);
    }
}
