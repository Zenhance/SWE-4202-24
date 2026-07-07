public class LifelineConnection extends ResidentialConnection{
    public double energyCharge(){
        return super.energyCharge() * 0.7;
    }
}
