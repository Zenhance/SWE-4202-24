public abstract class Connection {

    protected Meter meter;
    protected double fuelPercent = 0.10;
    protected double taxPercent  = 0.05;


    public Connection(Meter meter){
        this.meter = meter;
    }

    protected int units = meter.getUnitsConsumed();

    public abstract double energyCharge();
    public abstract double fixedCharge();
    public abstract double fuelSurcharge();
    public abstract double tax();
    public double total(){
        return energyCharge()+fixedCharge()+fuelSurcharge()+tax();
    };
}
