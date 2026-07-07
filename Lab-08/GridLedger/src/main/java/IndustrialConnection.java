public class IndustrialConnection extends Connection{
    public IndustrialConnection(Meter meter) {
        this.meter=meter;
    }

    @Override
    public double fixedCharge() {
        return 2000;
    }

    @Override
    public double energyCharge() {
        return meter.getUnitsConsumed() * 15.0;
    }

}
