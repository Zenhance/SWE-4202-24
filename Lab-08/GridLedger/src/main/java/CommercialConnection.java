public class CommercialConnection extends Connection{
    private static final double FIXED_CHARGE = 500.0;
    private static final int BAND_1_LIMIT = 100;
    private static final double RATE_1 = 9.0;
    private static final double RATE_2 = 13.0;

    public CommercialConnection(Meter meter){
        super(Meter meter, int FIXED_CHARGE);
    }

}
