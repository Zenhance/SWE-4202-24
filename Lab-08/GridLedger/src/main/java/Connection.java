public abstract class Connection {
    private Meter meter;
    private double Fuel_Charge = 0.10;
    private double Tax = 0.05;

    public Connection(Meter meter) {
        this.meter = meter;
    }

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
