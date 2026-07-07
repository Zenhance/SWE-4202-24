public abstract class Connection {
    private static final double TAX_RATE=0.05;
    private static final double DEFAULT_FUEL_SURCHARGE_RATE=0.10;

    private final Meter meter;
    private double fuelSurchargeRate;

    protected Connection(Meter meter){
        this.meter=meter;
        this.fuelSurchargeRate=DEFAULT_FUEL_SURCHARGE_RATE;

    }
    public int getUnits(){
        return meter.getUnitsConsumed();
    }

    void setFuelSurchargeRate(double fuelSurchargeRate){
        this.fuelSurchargeRate=fuelSurchargeRate;
    }
    public abstract double energyCharge();

    public abstract double fixedCharge();

    public double fuelSurcharge() {
        return energyCharge() * fuelSurchargeRate;

    }
    public double tax() {
        return (energyCharge() + fixedCharge() + fuelSurcharge()) * TAX_RATE;
    }

    public double total() {
        return energyCharge() + fixedCharge() + fuelSurcharge() + tax();
    }

}
