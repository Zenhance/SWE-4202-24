public abstract class Connection {
    private Meter meter;
    private double fuelPercentage=0.0;
    public Connection(Meter meter){
        if(meter==null){
            throw new IllegalArgumentException("Meter required");
        }
        this.meter=meter;
    }

    public abstract double energyCharge();

    public abstract double fixedCharge();

    public double fuelSurviceCharge(){
        return energyCharge()*fuelPercentage;
    }
}
