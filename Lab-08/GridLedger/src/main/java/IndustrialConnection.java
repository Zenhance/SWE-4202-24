public class IndustrialConnection extends Connection{
    private double Rate = 15.0;
    private double Fixed_Rate = 2000.0;
    private Meter meter;

    @Override
    public double fixedCharge() {
        return Fixed_Rate;
    }

    public double energyCharge() {
        int units = meter.getUnitsConsumed();
        return units*Rate;

    }




}
