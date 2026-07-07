public class ResidentialConnection extends Connection{
    private static final double RATE_1=4.0;
    private static final double RATE_2=7.0;
    private static final double RATE_3=11.0;
    private static final double FIXED_CHARGE=100.0;
    public ResidentialConnection(Meter meter){
        super(meter);
    }
    @Override
    public double energyCharge(){
        int units=getUnitsConsumed();
        if(units<=50){
            return units*RATE_1;
        }
        if(units<=200){
            return (50*RATE_1)+((units-50)*RATE_2);
        }
        return (50*RATE_1)+(150*RATE_2)+((units-200)*RATE_3);
    }
}
