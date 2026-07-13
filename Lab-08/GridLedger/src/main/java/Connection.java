abstract class Connection {
    private final Meter meter;
    private double fuelPercent = 0.10;
    private static final double TAX_PERCENT = 0.05;

    public Connection(Meter meter) {
        this.meter = meter;
    }

    protected int getUnits() {
        return meter.getUnits();
    }

    public double energyCharge() {
        return 0.0;
    }

    public double fixedCharge() {
        return 0.0;
    }

    public double fuelSurcharge() {
        return 0.0;
    }

    public double tax() {
        return 0.0;
    }

    public double total() {
        return energyCharge() == 0.0 ? 0.0 : energyCharge() * fuelPercent + fixedCharge() + fuelSurcharge() + tax();
    }

}
