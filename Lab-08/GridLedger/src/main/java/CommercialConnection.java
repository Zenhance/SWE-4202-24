public class CommercialConnection extends Connection{
    private static final double RATE_1=9.0;
    private static final double RATE_2=13.0;
    private static final double FIXED_CHARGE=500.00;
    public CommercialConnection(Meter meter){
        super(meter);
    }
}
