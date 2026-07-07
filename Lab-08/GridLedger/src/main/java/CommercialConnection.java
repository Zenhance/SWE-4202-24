public class CommercialConnection extends Connection{
    private static final double COM_RATE_1 = 9.0;
    private static final double COM_RATE_2 = 13.0;
    private static final double COM_FIXED  = 500.0;

    public CommercialConnection(Meter meter){
        super(meter);
    }

    @Override
    public double energyCharge() {
        int unit= getMeter().getUnitsConsumed();
        if (unit<=100){
            return unit*COM_RATE_1;
        }
        else {
           return 100*COM_RATE_1+(unit-100)*COM_RATE_2;
        }
    }

    @Override
    public double fixedCharge() {
        return COM_FIXED;
    }
}
