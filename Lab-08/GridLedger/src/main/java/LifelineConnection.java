public class LifelineConnection extends ResidentialConnection {
    public  LifelineConnection(Meter meter){
        super(meter);
    }

    @Override
    public double energyCharge() {
        return super.energyCharge()*(1.0-0.3);
    }

}
