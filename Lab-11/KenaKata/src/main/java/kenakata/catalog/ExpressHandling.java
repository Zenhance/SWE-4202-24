package kenakata.catalog;

public class ExpressHandling extends AddOn {
    @Override
    public long unitCharge() {
        return 120;
    }
    @Override
    public long unitVat() {
        return (120*75 + 999)/1000;
    }
    @Override
    public String label() {
        return "Express handling";
    }

}