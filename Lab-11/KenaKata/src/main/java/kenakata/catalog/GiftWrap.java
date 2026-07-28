package kenakata.catalog;

public final class GiftWrap implements Chargeable{
    private static final long CHARGE = 50;
    @Override
    public long unitCharge(){
        return charge;
    }

}
