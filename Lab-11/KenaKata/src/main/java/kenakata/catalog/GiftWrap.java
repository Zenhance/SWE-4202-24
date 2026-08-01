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

    public String label() {
        return "Gift wrap";
    }


}
