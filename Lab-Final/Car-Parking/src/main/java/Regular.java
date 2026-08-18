public class Regular extends Slot {
    public Regular(String license, String scheme) {
        super(license, scheme);
    }

    @Override
    public int calculateFee() {
        int hours = (getHours() == 0) ? 1 : getHours();
        int surcharge = isSurchargeApplied() ? 15 : 0;
        return applySchemeDiscount(30 + (hours - 1) * 20 + surcharge);
    }
}