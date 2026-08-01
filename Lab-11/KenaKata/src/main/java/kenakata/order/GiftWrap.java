package kenakata.order;

public class GiftWrap implements Chargeable{
    @Override
    public long unitCharge(){
        return 50;
    }
}
