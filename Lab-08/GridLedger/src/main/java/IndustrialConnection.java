public class IndustrialConnection extends Connection{
    public IndustrialConnection(Meter meter){
        super(meter);
    }
    @Override
    public double energyCharge(){
        int units= meter.getUnitsConsumed();
        return units*15.0;
    }
    @Override
    public double fixedCharge(){
        return 1000;
    }
}
