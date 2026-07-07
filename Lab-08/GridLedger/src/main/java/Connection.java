package main.java;

public abstract class Connection {
    private static final double FuelPercent=0.10;
    private static final double TaxPercent=0.05;
    private Meter meter;
public Connection(Meter meter){
this.meter=meter;
}
public abstract double energyCharge();
public abstract double fixedCharge();
public double fuelSurcharge(){
    return energyCharge()*FuelPercent;
}
public double Tax(){
    return (energyCharge()+fixedCharge()+fuelSurcharge())*TaxPercent;
}
public Double totalBill(){
    double sum=energyCharge()+fixedCharge()+fuelSurcharge()+Tax();
    return sum;
}

    public Meter getMeter() {
        return meter;
    }
}
