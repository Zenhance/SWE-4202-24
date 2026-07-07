public class LifeLineConnection extends ResidentialConnection {
    private static final double rate = 0.30;
    public LifeLineConnection(Meter meter) {
        super(meter);
    }

    public double energyCharge(){
        int units = meter.getUnitsConsumed();
        return units - (units * rate);
    }

}
