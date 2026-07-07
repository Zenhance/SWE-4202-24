public abstract class Connection {
    protected final Meter meter;
    private double fuelPercent = 0.10; // Default country-wide fuel surcharge (10%)

    public Connection(Meter meter) {
        if (meter == null) {
            throw new IllegalArgumentException("A valid meter is required.");
        }
        this.meter = meter;
    }

    // Allows modifying the fuel percentage for a specific connection if needed
    public void setFuelPercent(double fuelPercent) {
        this.fuelPercent = fuelPercent;
    }

    // Each specific category must implement its own rules here
    public abstract double energyCharge();
    public abstract double fixedCharge();

    // Centralized common calculations (eliminates code duplication)
    public double fuelSurcharge() {
        return energyCharge() * fuelPercent;
    }

    public double tax() {
        return (energyCharge() + fixedCharge() + fuelSurcharge()) * 0.05; // 5% default tax rate
    }

    public double total() {
        return energyCharge() + fixedCharge() + fuelSurcharge() + tax();
    }
}