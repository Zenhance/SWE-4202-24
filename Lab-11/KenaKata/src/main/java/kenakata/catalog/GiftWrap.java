package kenakata.catalog;

public class GiftWrap implements Chargeable {
    private static final double CHARGE=50;
    private static final double VAT_RATE_PERCENT=7.5;

    public double unitCharge(){
        return CHARGE;
    }
    public double unitVat(){
        return (double) Math.ceil(CHARGE*VAT_RATE_PERCENT/100.0);
    }
    public String label(){
        return "Gift wrapping";
    }
}
