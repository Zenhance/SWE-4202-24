public class IndustrialConnection extends Connection {

    public IndustrialConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double fixedCharge() {
        return 2000.0;
    }

    @Override
    public double energyCharge() {
        return meter.getUnitsConsumed() * 15.0;
    }
}