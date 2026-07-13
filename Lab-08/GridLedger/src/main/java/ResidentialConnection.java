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
        if(units <= 50){
            return units*RATE1;
        }

        if (units <=200){
            return 50 * RATE1 + (units - 50) * RATE2;
        }

        return 50*RATE1 + 150*RATE2 + (units -200)*RATE3;
    }

    @Override
    public double fixedCharge() {
        return FIXED;
    }
}
