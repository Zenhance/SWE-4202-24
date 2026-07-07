public abstract class Connection {

    protected Meter meter;
    private double fuelSurChargePercentage = 0.4;

    public Connection(Meter meter, double fuelSurChargePercentage ) {
        this.meter = meter;
        this.fuelSurChargePercentage = fuelSurChargePercentage;

    }
}