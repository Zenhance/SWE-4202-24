public class ResidentialConnection extends Connection{
    private static final double RATE1 = 4.0;
    private static final double RATE2 = 7.0;
    private static final double RATE3 = 11.0;
    private static final double FIXED = 100.0;

    public ResidentialConnection(Meter meter){
        super(meter);
    }

    @Override
    public double energyCharge(){
        int units = meter.getUnitsConsumed();
        if(units <= 100){
            return units*RATE1;
        }

        return 100*RATE1 + (units -100)*RATE2;
    }

    @Override
    public double fixedCharge() {
        return FIXED;
    }
}
