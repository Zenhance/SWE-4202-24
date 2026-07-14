public abstract class Connection {
    public Connection(Meter meter) {
        this.meter=meter;
    }
    public double fuelPercent =0.1;
    public double taxPercent=0.05;
    Meter meter;


    public double fixedCharge() {
        return 0;
    }

    public double fuelSurcharge() {

        return energyCharge()*fuelPercent;
    }

    public double tax() {
        return (energyCharge() + fixedCharge() + fuelSurcharge()) * taxPercent;
    }
    public double total() {
        return energyCharge() + fixedCharge() + fuelSurcharge() + tax();
    }

    public double energyCharge() {
        return 0;
    }
}


