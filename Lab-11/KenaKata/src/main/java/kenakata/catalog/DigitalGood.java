package kenakata.catalog;

public class DigitalGood extends CatalogItem{

    public DigitalGood(String a, String itemType, int unitPrice, int amount, Seller s) {
        super(a, itemType, unitPrice, amount, s, 0);
    }

    public int unitVat() {
        double x = Math.ceil(unitPrice*0.05);
        return (int) x ;
    }

    public int commissionOn(int i) {
        double x = Math.ceil(i*0.2);
        return (int) x;
    }
}
