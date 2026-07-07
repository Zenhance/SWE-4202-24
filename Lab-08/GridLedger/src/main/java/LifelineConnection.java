class LifelineConnection extends ResidentialConnection{
    public LifelineConnection(Meter meter){
        super(meter);
    }

    @Override
    public double energyCharge(){
        double c = super.energyCharge();
        return c - (c * 0.30);
    }
}