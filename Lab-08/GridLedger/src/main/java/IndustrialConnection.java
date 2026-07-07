public abstract class IndustrialConnection extends Connection{
    private static final double ind_rate1=15.0;
    private static final double ind_rate=2000.0;
    public IndustrialConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double energyCharge() {
        int unit = getMeter().getUnitsConsumed();
         return unit*ind_rate1;
    }

    @Override
    public double fixedCharge() {
        return ind_rate;
    }
}
