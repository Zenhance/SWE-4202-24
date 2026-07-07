public class CommercialConnection extends Connection{
    private static final double COM_RATE_1 = 9.0;
    private static final double COM_RATE_2 = 13.0;
    private static final double COM_FIXED  = 500.0;

    public CommercialConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double fixedCharge() {
        return COM_FIXED;
    }

    @Override
    public double energyCharge() {
        int units= getMeter().getUnitsConsumed();
        if(units>=100)
            return units*COM_RATE_1;
        else
            return units*COM_RATE_1 + (100-units)* COM_RATE_2;
    }
}
