public class CommercialConnection extends Connection{
    public CommercialConnection(Meter meter){
        super(meter);
    }
    @Override
    public double energyCharge() {
        if(meter.getUnitsConsumed()<100){
            return 100*9.0;
        }
        else {
            return 100*9.0 +(meter.getUnitsConsumed()-100)*13.5;
        }
    }

    @Override
    public double fixedCharge() {
        return 150.0;
    }
}
