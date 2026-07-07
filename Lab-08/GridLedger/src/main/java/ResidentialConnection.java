public class ResidentialConnection extends Connection {

    protected Meter meter;
    private double fuelSurChargePercentage;

    public ResidentialConnection(Meter meter, double fuelSurChargePercentage) {
        super(meter, fuelSurChargePercentage);
    }


    @Override
    double energyCharge() {

    }

}