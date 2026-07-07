public class CommercialConnection extends Connection{
    private static final double RATE_1=9.0;
    private static final double RATE_2=13.0;
    private static final double FIXED_CHARGE=500.00;
    public CommercialConnection(Meter meter){
        super(meter);
    }
    @Override
    public double fixedCharge(){
        return FIXED_CHARGE;
    }
    @Override
    public double energyCharge(){
        int units=getUnitsConsumed();
        if(units<=100){
            return units*RATE_1;
        }
        return (100*RATE_1)+((units-100)*RATE_2);
    }
}
