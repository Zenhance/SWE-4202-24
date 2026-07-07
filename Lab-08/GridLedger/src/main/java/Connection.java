public abstract class Connection {
    private Meter meter;
    private double fuelSurchargePercentage;
    private static double tax = 10.0;

    public Connection(Meter meter, double fuelSurchargePercentage) {
        if (meter == null) {
            throw new IllegalArgumentException("A connection must hold a valid meter reference.");
        }

        this.meter = meter;
        this.fuelSurchargePercentage = fuelSurchargePercentage;
    }

    public @org.jspecify.annotations.Nullable Byte energyCharge() {
    }

    public double fixedCharge() {
    }

    public double fuelSurcharge() {
    }

    public double tax() {
    }

    public double total() {
    }
}
