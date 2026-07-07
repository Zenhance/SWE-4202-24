abstract class Connection{

    double fuelPercent = 0.10;
    protected double taxPercent  = 0.05;
    Meter meter;

    public Connection(Meter meter){
        this.meter = meter;
    }

    public double energyCharge(){return 0;}

    public double fixedCharge(){return 0;}

    public double fuelSurcharge(){return energyCharge() * fuelPercent;}

    public double tax(){return (energyCharge() + fixedCharge() + fuelSurcharge()) * taxPercent;}

    public double total(){return energyCharge() + fixedCharge() + fuelSurcharge() + tax();}

}