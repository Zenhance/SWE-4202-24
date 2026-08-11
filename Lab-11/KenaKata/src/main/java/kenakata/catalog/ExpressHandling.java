package kenakata.catalog;

public class ExpressHandling implements Chargeable{
    public long unitVat() {
        return (long) Math.ceil(120*.075);
    }

    public long unitCharge() {
        return 120;
    }
    public String label(){
        return "Express Handaling";
    }
}
