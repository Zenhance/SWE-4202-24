package kenakata.catalog;

public class ExpressHandling implements Item {
    @Override
    public long unitCharge() { return 120; }

    @Override
    public long unitVat() {
        return (long) 0;
    }

    @Override
    public String label() { return "Express handling"; }
}

