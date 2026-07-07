public class LifelineConnection extends ResidentialConnection{
    public LifelineConnection(Meter M) {
        super(M);
    }

    @Override
    public double energyCharge(){
        double c = super.energyCharge();

        return c - (c * 0.30);
    }
}
