public abstract class Connection {
    private static final double TAX_RATE = 0.05;
    private static final double FUEL_DEFAULT    = 0.10;
    private final Meter meter;
    private final double fixedCharge;
    private double fuelSurchargePercent = FUEL_DEFAULT;

    protected Connection(Meter meter, double fixedCharge){
        this.meter = meter;
        this.fixedCharge = fixedCharge;
    }
    public abstract double energyCharge();

    public double fixedCharge(){
        return fixedCharge;
    }
    public double fuelSurcharge(){
        return energyCharge() * fuelSurchargePercent;
    }
}
