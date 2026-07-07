public class IndustrialConnection extends Connection{

    IndustrialConnection(Meter meter) {
        super(meter);
    }
    public double energyCharge(){
        int units = getUnits();
        return units * 15.0;
    }

    public double fixedCharge(){
        return 2000.0;
    }
}
