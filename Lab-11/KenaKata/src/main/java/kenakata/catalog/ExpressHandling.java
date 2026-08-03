package kenakata.catalog;

public class ExpressHandling extends AddOn {
    public long unitCharge() {
        return 120;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    public String label(){
        return "Express Handling";
    }
}
