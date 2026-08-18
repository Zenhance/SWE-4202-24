public class Large extends Slot {
    public Large(String license, String scheme) {
        super(license, scheme);
    }

    @Override
    public int calculateFee() {
        int hours = (getHours() == 0) ? 1 : getHours();
        int surcharge = isSurchargeApplied() ? 25 : 0;
        return applySchemeDiscount(50 + (hours - 1) * 40 + surcharge);
    }
}