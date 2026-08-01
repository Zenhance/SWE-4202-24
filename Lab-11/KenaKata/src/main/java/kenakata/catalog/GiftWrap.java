package kenakata.catalog;

public class GiftWrap implements Chargeable{
    @Override
    public long unitCharge() {
        return 50;
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(unitCharge() * 0.075);
    }




}
