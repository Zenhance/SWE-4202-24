package kenakata.catalog;

public class GiftWrap implements Chargeable{


    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public String lebel() {
        return "";
    }

    public String label() {
    }
}
