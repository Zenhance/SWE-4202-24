public abstract class Connection { private static final double FUEL_DEFAULT    = 0.10; // fuel surcharge = this % of the energy charge
    private static final double TAX_RATE        = 0.05;
    Meter meter;
    public Connection(Meter meter){
        this.meter=meter;
    }
    protected int getUnitsConsumed(){
        return meter.getUnitsConsumed();
    }

    public abstract double energyCharge() ;
    public abstract  double fixedCharge();
    public double fuelSurcharge(){
        return energyCharge()*FUEL_DEFAULT;
    }
    public double tax(){
        return (energyCharge()+fixedCharge()+fuelSurcharge())*TAX_RATE;
    }
   public double total(){
        return energyCharge()+fixedCharge()+fuelSurcharge()+tax();
   }


}
