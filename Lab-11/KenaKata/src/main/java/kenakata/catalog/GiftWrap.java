package kenakata.catalog;

public class GiftWrap {
    public final int unitPrice=50;

    public int unitVat() {
        return (int) Math.ceil(unitPrice*0.075);
    }
    public int unitCharge() {
        return (int) Math.ceil(unitPrice);
    }
}
