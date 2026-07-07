public class IndustrialConnection extends Connection{
    private static final double IND_RATE   = 15.0;
    private static final double IND_FIXED  = 2000.0;
    public IndustrialConnection(Meter meter) {
        super(meter);
    }
}
