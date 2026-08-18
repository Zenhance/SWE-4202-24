public abstract class Vehicle {

    private final String plate;
    private final DiscountScheme discount;
    protected Vehicle(String plate, DiscountScheme discount) {
        this.plate=plate;
        this.discount=discount;
    }
    public String getPlate() {
        return plate;
    }
    public DiscountScheme getDiscount() {
        return discount;
    }
    public abstract String getKind();

}