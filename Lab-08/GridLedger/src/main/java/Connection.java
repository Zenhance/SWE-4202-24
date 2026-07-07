public abstract class Connection {
    private final Meter meter;
    private double fuelPercent=.10;
    public Connection(Meter meter){
        this.meter=meter;
    }
    public Meter getMeter(){
        return meter;
    }
    public void setFuelPercent(double fuelPercent) {
        this.fuelPercent = fuelPercent;}
    public abstract double energyCharge();
    public abstract double fixedCharge();
    public double furlSurcharge(){
        return energyCharge()*fuelPercent;}
    public double tax(){
        return (energyCharge()+fixedCharge()+furlSurcharge()) * 0.05;}
    public double total(){
        return energyCharge()+fixedCharge()+furlSurcharge()+tax();}
    }
