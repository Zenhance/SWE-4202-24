abstract  class Connection {
    private Meter meter;

    protected double fuelPercent=0.10;
    protected final double taxPercent=0.05;

    public Connection(Meter meter){
        this.meter=meter;
    }
    protected Meter getMeter(){
        return meter;
    }

    public abstract double energyCharge();
    public abstract double fixedCharge();

    public void setFuelPercent(double fuelPercent) {
        this.fuelPercent = fuelPercent;
    }

    public double fuelSurcharge(){
        return energyCharge()*fuelPercent;

    }

    public double tax(){
        return (energyCharge()+fixedCharge()+fuelSurcharge())*taxPercent;

    }

    public double total(){
        return energyCharge()+fixedCharge()+fuelSurcharge()+tax();

    }

}
