public abstract class Connection {
    private static final double fuelpercent=0.10;
    private static final double taxpercent=0.05;
    private Meter meter;
    public Connection(Meter meter){
        this.meter=meter;
    }

     public Meter getMeter(){
        return meter;
     }


    public abstract double energyCharge();
    public abstract double fixedCharge();
    public double fuelSurcharge(){
        return energyCharge()* Connection.fuelpercent;}
    public double tax(){
        return (energyCharge()+fixedCharge()+fuelSurcharge())*taxpercent;
    }
    public double sum(){
        return energyCharge()+fixedCharge()+fuelSurcharge()+tax();
    }


}
