public class IndustrialConnection extends Connection {
    public IndustrialConnection(Meter M){
        super(M);
    }

    @Override
    public double energyCharge() {
        return units * 15.0;
    }

    @Override
    public double fixedCharge() {
        return 2000.0;
    }
}
