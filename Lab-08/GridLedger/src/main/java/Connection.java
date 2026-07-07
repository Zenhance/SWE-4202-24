public abstract class Connection {
    protected Meter meter;
    protected double fuelPercentage=0.10;
    protected double taxPercentage=0.05;

    public Connection(Meter meter){
        this.meter=meter;
    }
    public Meter getMeter(){
        return meter;
    }

    public abstract double getEnergyCharge();
    public abstract double getFixedCharge();

    public double getFuelSurcharge(){
        return getEnergyCharge()*fuelPercentage;
    }

    public double getTax(){
        double subtotal= getEnergyCharge()+getFixedCharge()+getFuelSurcharge();
        return subtotal*taxPercentage;
    }

    public double getTotalBill(){
        return getEnergyCharge()+getFixedCharge()+getFuelSurcharge()+getTax();
    }

    public void setFuelPercentage(double fuelPercentage){
        this.fuelPercentage=fuelPercentage;
    }
}
