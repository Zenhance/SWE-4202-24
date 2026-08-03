package kenakata.order;

public class ExpressHandling implements Chargeable{
    @Override
    public long unitCharge(){
        return 120;
    }
}
