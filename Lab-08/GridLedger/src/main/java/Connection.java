public abstract class Connection {
    public double Fuel_Charge = 0.10;
    public double Tax = 0.05;

    public abstract double fixedCharge();
    public abstract double energyCharge();

    public double fuelSurcharge() {
        return energyCharge()*Fuel_Charge;
    }

    public double tax() {
        return (energyCharge()+fixedCharge()+fuelSurcharge())*Tax;
    }

    public double total() {
        return (energyCharge()+fixedCharge()+fuelSurcharge()+tax());
    }



}
