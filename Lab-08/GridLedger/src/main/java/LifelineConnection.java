public class LifelineConnection extends ResidentialConnection {
    private static final double rate = 0.30;
    public LifelineConnection(Meter meter) {
        super(meter);
    }

    public double energyCharge(){
        double c = super.energyCharge();
        return c - (c * rate);
    }

}
