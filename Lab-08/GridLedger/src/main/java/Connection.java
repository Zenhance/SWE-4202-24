public abstract class Connection {
    protected Meter meter;
    protected double fuelSurchargePercentage=0.10;
    protected double taxPercentage=0.05;

    public Connection(Meter meter){
        this.meter=meter;
    }
    public Meter getMeter(){
        return meter;
    }

    public abstract double energyCharge();
    public abstract double fixedCharge();

    public double fuelSurcharge(){
        return energyCharge()*fuelSurchargePercentage;
    }

    public double tax(){
        double subtotal= energyCharge()+fixedCharge()+fuelSurcharge();
        return subtotal*taxPercentage;
    }

    public double total(){
        return energyCharge()+fixedCharge()+fuelSurcharge()+tax();
    }

    public void setFuelSurchargePercentage(double fuelPercentage){
        this.fuelSurchargePercentage=fuelPercentage;
    }
}
