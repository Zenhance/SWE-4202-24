public class IndustrialConnection extends Connection{
    private static final double RATE=15.0;
    private static final double FIXED_CHARGE=2000.0;
    public IndustrialConnection(Meter meter){
        super(meter);
    }
    @Override
    public double fixedCharge(){
        return FIXED_CHARGE;
    }
    @Override
    public double energyCharge(){
        return getUnitsConsumed()*RATE;
    }
}
