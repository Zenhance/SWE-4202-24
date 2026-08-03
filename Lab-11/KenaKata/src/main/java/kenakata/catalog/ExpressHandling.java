package kenakata.catalog;

public class ExpressHandling implements OrderableLine{
    private static final double vat=0.075;
    private static final int charge=120;
    @Override
    public long unitVat() {
        return (long)Math.ceil(unitCharge()*vat);
    }

    @Override
    public String label() {
        return "Express handling";
    }

    @Override
    public long unitCharge() {
        return charge;
    }
}
