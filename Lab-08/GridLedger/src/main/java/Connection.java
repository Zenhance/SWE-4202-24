abstract class Connection {
    private final Meter meter;

    public Connection(Meter meter) {
        this.meter = meter;
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
        return energyCharge() == 0.0 ? 0.0 : energyCharge() * 0.1 + fixedCharge() + fuelSurcharge() + tax();
    }

}
