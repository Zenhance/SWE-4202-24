package kenakata.catalog;




public final class GiftWrap implements Chargeable, Labeled {

    private static final long CHARGE = 50;
    private static final double VAT = 7.5/100.0;

    @Override
    public long unitCharge() {
        return CHARGE;
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(CHARGE*VAT);
    }



    @Override
    public String label() {
        return "Gift wrap";
    }
}
