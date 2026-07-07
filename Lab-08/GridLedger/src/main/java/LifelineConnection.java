public class LifelineConnection extends ResidentialConnection {

    public static final double rebate = 0.30;

    public LifelineConnection(Meter meter){
        super(meter);
    }
    @Override
    public double energyCharge(){
        return super.energyCharge()*(1-rebate);
    }



}
