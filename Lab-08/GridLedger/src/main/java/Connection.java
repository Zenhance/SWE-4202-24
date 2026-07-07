public abstract class Connection {


    protected Meter meter;
    protected double fuelPercentage = 0.10;

    public Connection(Meter meter){
        this.meter = meter;
    }
    public abstract double energyCharge();
    public abstract double fixedCharge();

    public double fuelSurcharge() {
        return energyCharge() * fuelPercentage;
    }
    public double tax() {
        return (energyCharge() + fuelSurcharge() + fixedCharge()) * .05;
    }

}
