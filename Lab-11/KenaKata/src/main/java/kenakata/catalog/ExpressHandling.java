package kenakata.catalog;

public class ExpressHandling implements Chargeable{

    @Override
    public long unitVat() {
        return 9;
    }

    @Override
    public long unitCharge() {
        return 120;
    }



    @Override
    public String label() {
        return "";
    }

}
