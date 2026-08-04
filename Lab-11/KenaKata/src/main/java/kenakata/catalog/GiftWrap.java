package kenakata.catalog;

public class GiftWrap implements Chargeable{
    public long unitCharge(){
        return 50;
    }
    public long unitVat(){
        return (long)Math.ceil(unitCharge()*(7.5*0.01));
    }
    public String label(){
        return "Gift wrapping";
    }
}
