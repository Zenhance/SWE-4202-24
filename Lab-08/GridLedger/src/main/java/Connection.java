public abstract class Connection {

    protected Meter meter;
    private double fuelSurChargePercentage;
    protected static final double TAX_PERCENTAGE;

    public Connection(Meter meter, double fuelSurChargePercentage ) {
        this.meter = meter;
        this.fuelSurChargePercentage = fuelSurChargePercentage;
    }

    public Meter getMeter() {
        return meter;
    }

    public abstract double energyCharge();
    public abstract double fixedCharge();

    public double fuelSurCharge() {
        return fuelSurChargePercentage*energyCharge();
    }

    public double tax() {
        double subtotal = energyCharge() + fixedCharge() + fuelSurCharge();
        return subtotal*TAX_PERCENTAGE;
    }

    public double total() {

    }
}