public class IndustrialConnection extends Connection{
    public IndustrialConnection(Meter meter){
        super(meter);
    }
    @Override
    public double energyCharge(){
        int units= getMeter().getUnitsConsumed();
        return units * 15.0;
    }
    @Override
    public  double fixedCharge(){
        return 2000.0;
    }
}

