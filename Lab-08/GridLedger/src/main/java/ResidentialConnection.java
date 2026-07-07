public class ResidentialConnection extends Connection {
    public ResidentialConnection(Meter meter) {

            super(meter);

    }

    @Override
    public double energyCharge() {
        return 0;
    }

    @Override
    public double fixedCharge() {
        return 0;
    }
}
