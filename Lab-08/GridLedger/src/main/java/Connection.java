public abstract class Connection {
    private Meter meter;
    private double fuelSurchargePercentage;
    private static double tax = 10.0;

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
