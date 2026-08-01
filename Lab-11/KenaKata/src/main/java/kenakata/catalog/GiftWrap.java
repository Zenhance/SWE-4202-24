package kenakata.catalog;

public class GiftWrap implements Chargeable {
    @Override
    public long unitCharge(){
        return 50;
    }

    @Override
    public long unitVat(){
        return (long)Math.ceil(unitCharge()*(7.5*0.01));
    }

    public String label(){
        return "Gift wrapping";
    }
}
