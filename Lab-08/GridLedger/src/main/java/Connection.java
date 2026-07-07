public abstract class Connection{

    private Meter meter;
    private double fuelRate;

    public Connection(Meter meter) {
        this.meter = meter;
        this.fuelRate = 0.10;
    }

    public abstract double energyCharge();

    public abstract double fixedCharge();

    public double fuelSurcharge() {
        return this.energyCharge() * fuelRate;
    }

    public double tax() {
        double subtotal = this.energyCharge() + this.fixedCharge() + this.fuelSurcharge();
        return subtotal * 0.05;
    }

    public double total() {
        return this.energyCharge() + this.fixedCharge() + this.fuelSurcharge() + this.tax();
    }

    public Meter getMeter() {
        return meter;
    }

    public void setFuelRate(double fuelRate) {
        if (fuelRate <= 0) return;
        this.fuelRate = fuelRate;
    }
}
