public class ResidentialConnection extends Connection{
    private double Rate_1 = 4.0;
    private double Rate_2 = 7.0;
    private double Rate_3 = 11.0;
    private double Rate_Fixed = 100.0;

    @Override
    public double fixedCharge() {
        return Rate_Fixed;
    }

    @Override
    public double energyCharge() {

    }










}
