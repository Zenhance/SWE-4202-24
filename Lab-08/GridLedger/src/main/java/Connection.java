public abstract class Connection {
    protected Meter meter;
    protected double fuelSurchargePercent;
    private static double TAX_PERCENT;

    protected Connection(Meter meter){
        this.meter = meter;
        this.fuelSurchargePercent = 0;
    }
    protected Connection(Meter meter, double fuelSurchargePercent){
        this.meter = meter;
        this.fuelSurchargePercent = fuelSurchargePercent;
    }

    public abstract double energyCharge();
    public abstract double fixedCharge();

    public double fuelSurcharge(){
        return energyCharge() * fuelSurchargePercent;
    }

    public double tax() {
        return (energyCharge() + fixedCharge() + fuelSurcharge()) * TAX_PERCENT;
    }

    public double total() {
        return energyCharge() + fixedCharge() + tax() + fuelSurcharge();
    }
}
