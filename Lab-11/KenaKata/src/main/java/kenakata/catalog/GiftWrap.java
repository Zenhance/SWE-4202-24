package kenakata.catalog;



/** Flat-charge add-on: gift wrapping. Earns no seller commission; belongs to the platform. */
public final class GiftWrap implements Chargeable, Labeled {

    private static final long CHARGE = 50;
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
        return "Gift wrap";
    }
}
