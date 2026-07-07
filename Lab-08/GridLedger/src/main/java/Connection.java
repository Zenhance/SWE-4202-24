public abstract class Connection{

    private Meter meter;

    public Connection(Meter meter) {
        this.meter = meter;
    }

    public abstract double energyCharge();

    public abstract double fixedCharge();

    public double fuelSurcharge() {
        return this.energyCharge() * 0.10;
    }

    public double tax() {
        double subtotal = this.energyCharge() + this.fixedCharge() + this.fuelSurcharge();
        return subtotal * 0.05;
    }
}
