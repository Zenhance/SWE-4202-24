package kenakata.catalog;

public final class GiftWrap implements Chargeable{
    private static final long CHARGE = 50;
    @Override
    public long unitCharge(){
        return CHARGE;
    }
    @Override
    public long unitVat(){
        return MoneyMath.ceilFraction(CHARGE,75,1000);
    }
    @Override
    public String label(){
        return "Gft wrapping";
}
}
