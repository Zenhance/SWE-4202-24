public class ResidentialConnection extends Connection{
    private static final double RES_RATE_1 = 4.0;   // first 50 units
    private static final double RES_RATE_2 = 7.0;   // units 51..200
    private static final double RES_RATE_3 = 11.0;  // units above 200
    private static final double RES_FIXED  = 100.0;
    public ResidentialConnection(Meter meter){
        super(meter);
    }

    @Override
    public double energyCharge() {
        int units=getUnitsConsumed();
        if (units<=50)
            return units*RES_RATE_1;
        if (units<=200)
            return (50*RES_RATE_1)+ ((units-50)*RES_RATE_2);
        return (50*RES_RATE_1)+(150*RES_RATE_2)+((units-200)*RES_RATE_3);
    }

    @Override
    public double fixedCharge() {
        return RES_FIXED;
    }
}
