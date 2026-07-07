public abstract class CommercialConnection extends Connection {
    private static final double com_rate1=9.0;
    private static final double com_rate2=13.0;
    private static final double com_rate=500.0;

    public CommercialConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double energyCharge() {
        int unit =getMeter.getUnitsConsumed;
        if(unit<=100)
            return com_rate1;
        else
            return com_rate1*100+(unit-100)*com_rate2;
    }

    @Override
    public double fixedCharge() {
        return com_rate;
    }
}
