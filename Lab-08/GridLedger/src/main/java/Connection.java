public abstract class Connection {
    protected Meter meter;
    public double fuelSurcharge=0.05;
    public double taxCharge=0.15;
    public int fixedCharge;
    public int energyCharge;
    public Connection(Meter meter){
        if(meter==null){
            throw new IllegalArgumentException("Can't be null!");
        }
        this.meter=meter;
    }

    public abstract double energyCharge();
    public abstract double fixedCharge();

    public void setfuelSurcharge(double percentage){
        this.fuelSurcharge=percentage;
    }
    public double fuelSurcharge(){
        return energyCharge()*fuelSurcharge*fixedCharge();
    }
    public double taxCharge(){
        return (energyCharge()+fuelSurcharge()+fixedCharge())*taxCharge;
    }
    public double total(){
        return (energyCharge()+fuelSurcharge()+fixedCharge()+taxCharge());
    }

}
