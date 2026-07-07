public abstract class Connection {
    public final Meter meter;
    private double fuelPercentage=0.10;
    public Connection(Meter meter){
        if(meter==null) {
            throw new IllegalArgumentException("error");
        }
            this.meter=meter;

    }
    public Meter getMeter(){
        return meter;

    }
    public void setFuelPercentage(double fuelPercentage){
        this.fuelPercentage=fuelPercentage;

    }
    public int getUnitsConsumed(){
        return meter.getUnitsConsumed();
    }
    public abstract double energyCharge();
    public abstract double fixedCharge();
    public double fuelSurcharge(){
        return energyCharge()*fuelPercentage;
    }
    public double tax(){
        return (energyCharge()+fixedCharge()+fuelSurcharge())*0.05;
    }
    public double total(){
        return energyCharge()+fixedCharge()+fuelSurcharge()+tax();
    }
}
