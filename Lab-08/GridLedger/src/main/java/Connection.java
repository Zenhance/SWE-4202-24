public abstract class Connection {
    private double fuelSurchargePercentage = 0.10;
    private double taxSurchargePercentage = 0.05;

    Meter meter;


    abstract public double energyCharge();
    abstract public double fixedCharge();\

    public double fuelSurcharge() {
        return energyCharge() * fuelSurchargePercentage;
    }
    public double tax(){
        return (energyCharge() + fixedCharge() + fuelSurcharge()) * taxSurchargePercentage ;
    }

    public double total(){
        return energyCharge() + fixedCharge() + fuelSurcharge() + tax();
    }


}
