public class Connection {
    protected Meter meter;
    public double fuelSurcharge=0.05;
    public double fuelCharge=0.15;
    public int fixedCharge;
    public int energyCharge;
    public Connection(Meter meter){
        if(meter==null){
            throw new IllegalArgumentException("Can't be null!");
        }
        this.meter=meter;
    }
    public void energyCharge(){}
    public void fixedCharge(){
    }
    public double fuelSurcharge(){
        return energyCharge()*fuelSurcharge;
    }
}
