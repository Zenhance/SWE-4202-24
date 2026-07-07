public class ResidentialConnection extends Connection{
    private double Rate_1 = 4.0;
    private double Rate_2 = 7.0;
    private double Rate_3 = 11.0;
    private double Rate_Fixed = 100.0;
    private Meter meter;


    @Override
    public double fixedCharge() {
        return Rate_Fixed;
    }

    @Override
    public double energyCharge() {
        int units = meter.getUnitsConsumed();
        if(units <= 50) {
            return units*Rate_1;
        }
        if(units <= 200) {
            return (50*Rate_1) + ((units-50)*Rate_2);
        }
        return (50*Rate_1) + (150*Rate_2) + ((units-200)*Rate_3);

    }


}
