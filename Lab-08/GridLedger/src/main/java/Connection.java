public abstract class Connection {
    private double fuelSurchargePercentage = 0.10;
    private double taxSurchargePercentage = 0.05;


    abstract public double energyCharge();
    abstract public double fixedCharge();\

    public double fuelSurcharge() {
        return energyCharge() * fuelSurchargePercentage;
    }
    public double tax(){
        return (energyCharge() + fixedCharge() + fuelSurcharge()) * taxSurchargePercentage ;
    }


}
