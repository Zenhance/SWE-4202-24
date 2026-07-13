public class CommercialConnection extends Connection{
    private static final double RATE1 = 9.0;
    private static final double RATE2 = 13.0;
    private static final double FIXED = 500;

    public CommercialConnection(Meter meter){
        super(meter);
    }

    @Override
    public double energyCharge(){
        int units = meter.getUnitsConsumed();
        if(units <=100){
            return units*RATE1;
        }
        return  100*RATE1 + (units - 100)*RATE2;
    }

    @Override
    public double fixedCharge(){
        return FIXED;
    }
}
