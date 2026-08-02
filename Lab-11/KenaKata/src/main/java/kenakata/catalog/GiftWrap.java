package kenakata.catalog;

public class GiftWrap implements Chargeable{
    public int unitVat() {
        return 0;
    }

    public int unitCharge() {
        return 0;
    }

    public String label() {
        return "Hello";
    }
}
