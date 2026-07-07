public class IndustrialConnection extends Connection {
    public IndustrialConnection(Meter M){
        super(M);
    }

    private double RATE = 15.0;
    @Override
    public double energyCharge() {
        return units * RATE;
    }

    @Override
    public double fixedCharge() {
        return 2000.0;
    }
}
