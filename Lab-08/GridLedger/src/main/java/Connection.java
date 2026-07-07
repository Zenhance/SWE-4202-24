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

    public Meter getMeter() {
        return meter;
    }

    public static double getTax() {
        return tax;
    }

    public double getFuelSurchargePercentage() {
        return fuelSurchargePercentage;
    }

    public void setFuelSurchargePercentage(double fuelSurchargePercentage) {
        this.fuelSurchargePercentage = fuelSurchargePercentage;
    }

    protected int getUnits(){
        return meter.getUnitsConsumed();
    }



}
