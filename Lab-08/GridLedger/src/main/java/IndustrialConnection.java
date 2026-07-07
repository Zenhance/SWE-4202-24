public class IndustrialConnection extends Connection{
    public double energyCharge(){
        int units = meter.getUnitsConsumed();
        return units * 15.0;
    }

    public double fixedCharge(){
        return 2000.0;
    }
}
