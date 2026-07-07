public class ResidentialConnection extends Connection{
    private static final double RES_RATE_1=4.0;
    private static final double RES_RATE_2=7.0;
    private static final double RES_RATE_3=11.0;
    private static final double RES_FIXED=100.0;

    public ResidentialConnection(Meter meter){
        super(meter);
    }

    @Override
    public double energyCharge() {

    }
}
