public abstract class Connection {
    private Meter meter;
    private double fuelSurchargePercentage = 0.10;
//    private static double tax = 0.05;

    public Connection(Meter meter) {
        if (meter == null) {
            throw new IllegalArgumentException("A connection must hold a valid meter reference.");
        }

        this.meter = meter;
    }

    public Meter getMeter() {
        return meter;
    }

    public double fuelSurcharge() {
        return energyCharge() * (fuelSurchargePercentage);
    }

    public void setFuelSurchargePercentage(double fuelSurchargePercentage) {
        this.fuelSurchargePercentage = fuelSurchargePercentage;
    }

    protected int getUnits() {
        return meter.getUnitsConsumed();
    }

    public abstract double energyCharge();

    public abstract double fixedCharge();

    public double tax() {
        double subtotal = energyCharge() + fixedCharge() + fuelSurcharge();
        return subtotal * (0.05);
    }

    public double total() {
        return energyCharge() + fixedCharge() + fuelSurcharge() + tax();
    }
}