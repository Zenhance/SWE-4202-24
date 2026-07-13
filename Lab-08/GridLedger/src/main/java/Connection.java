public abstract class Connection{
    protected final Meter meter;
    protected double fuelPet = 0.10;
    protected static final double taxPet = 0.05;

    public Connection(Meter meter) {
        this.meter = meter;
    }

    public abstract double energyCharge();
    public abstract double fixedCharge();

    public double fuelSurcharge(){
        return energyCharge()*fuelPet;

    }

    public  double tax(){
        return (energyCharge()+ fixedCharge()+fuelSurcharge()*taxPet);
    }

    public double total(){
        return energyCharge()+ fuelSurcharge()+ fixedCharge()+ tax();
    }

    public void setFuelPet(double fuelPet){
        this.fuelPet = fuelPet;
    }
}