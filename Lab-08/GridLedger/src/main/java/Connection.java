public abstract class Connection{
    protected double energy;
    protected double fixed;
    protected double fuelPet;
    protected double taxPet;

    public abstract double energyCharge();
    public abstract double fixedCharge();

    public double fuelSurcharge(){
        return energyCharge()*fuelPet;

    }

    public  double tax(){
        return (energyCharge()+ fixedCharge()+fuelSurcharge()+taxPet);
    }
}