public abstract class Connection {
    private static final double FUEL_DEFAULT    = 0.10;
    private static final double TAX_RATE        = 0.05;
    private static final double LIFELINE_REBATE = 0.30;
    private double fuelPercent=FUEL_DEFAULT;

    private static final double EPS = 1e-6;
    private Meter meter;

    public Connection(Meter meter){
        this.meter=meter;
    }

    void setFuelDefault(double fuelPercent){
        this.fuelPercent=fuelPercent;

    }
    public Meter getMeter(){
        return meter;
    }


     abstract double energyCharge();
    abstract double fixedCharge();
    public double fuelSurcharge(){
        return energyCharge() * fuelPercent;
    }
    public double tax(){
        return (energyCharge()+fixedCharge()+fuelSurcharge())*TAX_RATE;
    }
    double total() {
        return energyCharge() + fixedCharge() + fuelSurcharge() + tax();
    }

}
