package main.java;

import java.Meter;

public abstract class Connection {
    private final Meter meter;
    private  double fuelPercent = 0.10;
    private static final double taxPercent  = 0.05;
    protected Connection(Meter meter){
        this.meter = meter;
    }
    protected int unitConsumed(){
        return meter.totalUsages();
    }
    public abstract double energyCharge();


    public abstract double fixedCharge();
    public double fuelSurcharge(){
        return energyCharge() * fuelPercent;
    }
    public double tax(){
        return (energyCharge() + fixedCharge() + fuelSurcharge()) * taxPercent;
    }
    public double totalBill(){
        return energyCharge()+fixedCharge()+fuelSurcharge()+tax();
    }




}
