class LifelineConnection extends ResidentialConnection{
    public LifelineConnection(Meter meter){
        super(meter);
    }

    public double energyCharge(){
        double c = super.energyCharge();
        return c - (c * 0.30);
    }
}