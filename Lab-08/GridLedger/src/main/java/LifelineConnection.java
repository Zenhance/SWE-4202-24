public class LifelineConnection extends ResidentialConnection{

    LifelineConnection(Meter meter) {
        super(meter);
    }
    public double energyCharge(){
        return super.energyCharge() * 0.7;
    }
}
