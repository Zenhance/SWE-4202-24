public class Bike extends Slot {
    public Bike(String license, String scheme) {
        super(license, scheme);
    }

    @Override
    public int calculateFee() {
        int hours = (getHours() == 0) ? 1 : getHours();
        return applySchemeDiscount(10 + (hours - 1) * 5);
    }
}