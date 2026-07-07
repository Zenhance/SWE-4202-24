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

    public double getFuelSurcharge(){
        return energyCharge()*fuelSurchargePercentage;
    }

    public double getTax(){
        double subtotal= energyCharge()+fixedCharge()+getFuelSurcharge();
        return subtotal*taxPercentage;
    }

    public double getTotalBill(){
        return energyCharge()+fixedCharge()+getFuelSurcharge()+getTax();
    }

    public void setFuelSurchargePercentage(double fuelPercentage){
        this.fuelSurchargePercentage=fuelPercentage;
    }
}
