package kenakata.catalog;

public class GiftWrap {
    private final int unitPrice = 50;


    public int unitCharge() {
        return unitPrice;
    }

    public int unitVat() {
        return (int) Math.ceil(unitPrice * 0.075);
    }

    public int commissionOn(int something) {
        return (int) Math.ceil(something * 0.00);
    }


}
