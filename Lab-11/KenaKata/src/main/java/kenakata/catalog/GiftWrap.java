package kenakata.catalog;

public class GiftWrap implements Chargeable{
    public long unitCharge(){
        return 50;
    }

    @Override
    public long unitVat() {
        return (long)Math.ceil(50*0.075);
    }

    @Override
    public String label() {
        return "Gift Wrapping";
    }
}
