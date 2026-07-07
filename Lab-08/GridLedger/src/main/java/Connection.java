public abstract class Connection {
    public double fuelPercent = 0.10;
    public double taxPercent  = 0.05;

    protected final Meter meter;

    public Connection(Meter meter) {
        this.meter = meter;
    }

    public abstract double energyCharge();
    public abstract double fixedCharge();

    public double fuelSurcharge() {
        return energyCharge()*fuelPercent;
    }

    public double tax(){
        return (energyCharge()+fixedCharge()+fuelSurcharge())*taxPercent;
    }

    public double total(){
        return energyCharge()+fixedCharge()+fuelSurcharge()+tax();
    }
}
