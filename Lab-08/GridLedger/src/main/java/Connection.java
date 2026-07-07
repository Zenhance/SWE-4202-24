public class Connection {
    private final Meter meter;
    private double fuelPercentage=0.10;
    private static final double TAX_RATE=0.05;
    public Connection(Meter meter){
        this.meter=meter;
    }
    protected int getUnitsConsumed(){
        return meter.getUnitsConsumed();
    }
    public void setFuelPercentage(double fuelPercentage){
        this.fuelPercentage=fuelPercentage;
    }
    public abstract double energyCharge();
    public abstract double fixedCharge();
    public double fuelSurcharge(){
        return energyCharge()*fuelPercentage;
    }
}
