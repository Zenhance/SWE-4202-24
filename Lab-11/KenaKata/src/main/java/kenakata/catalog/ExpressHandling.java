package kenakata.catalog;

public class ExpressHandling implements Chargeable{

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public String label() {
        return "";
    }

}
