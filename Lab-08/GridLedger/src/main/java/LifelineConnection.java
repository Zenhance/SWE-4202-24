public class LifelineConnection extends ResidentialConnection {
    private double rebate=0.30;

    public LifelineConnection(Meter meter){
        super(meter);
    }
    @Override
    public double energyCharge(){
        return super.energyCharge()
        -(super.energyCharge()*rebate);
    }

}
