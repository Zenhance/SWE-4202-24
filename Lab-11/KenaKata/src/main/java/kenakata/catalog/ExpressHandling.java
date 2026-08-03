package kenakata.catalog;

public class ExpressHandling implements Chargeable {


    @Override
    public long unitVat() {return (long) Math.ceil(120 * 0.075);}

    @Override
    public long unitCharge() {
        return 120;
    }



    public int commissionOn(int total) {
        return (int) Math.ceil(total*0.00);
    }
}


