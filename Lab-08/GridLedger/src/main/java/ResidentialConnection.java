public class ResidentialConnection extends Connection {
    private static final double FIXED_CHARGE = 100.0;
    private static final int BAND_1_LIMIT = 50;
    private static final int BAND_2_LIMIT = 200;
    private static final double RATE_1 = 4.0;
    private static final double RATE_2 = 7.0;
    private static final double RATE_3 = 11.0;

    public ResidentialConnection(Meter meter){
        super(meter, FIXED_CHARGE);
    }
    @Override
    public double energyCharge(){
        int units = getUnitsConsumed();
        if (units<=BAND_1_LIMIT) return units*RATE_1;
        if (units<=BAND_2_LIMIT) return (BAND_1_LIMIT*RATE_1)+((units-BAND_1_LIMIT)*RATE_2);
        return (BAND_1_LIMIT*RATE_1)
                + ((BAND_2_LIMIT-BAND_1_LIMIT)*RATE_2)
                + ((units-BAND_2_LIMIT)*RATE_3);
    }
}
