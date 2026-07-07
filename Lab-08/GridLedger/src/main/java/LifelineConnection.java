public class LifelineConnection extends ResidentialConnection{
    private double Rebate = 0.3;


    @Override
    public double energyCharge() {
        return super.energyCharge() * (1.0 - Rebate);
    }
}
