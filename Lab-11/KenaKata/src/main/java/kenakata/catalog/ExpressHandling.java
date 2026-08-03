package kenakata.catalog;


public final class ExpressHandling implements Chargeable, Labeled {

    private static final long CHARGE = 120;
    private static final double VAT = 7.5;

    @Override
    public long unitCharge() {
        return CHARGE;
    }

    @Override
    public long vatCharge() {
        return (long) Math.ceil(CHARGE*VAT);
    }



    @Override
    public String label() {
        return "Express handling";
    }
}
