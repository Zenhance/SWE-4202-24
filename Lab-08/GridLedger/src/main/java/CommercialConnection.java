public class CommercialConnection extends Connection {

    protected Meter meter;
    private final double fuelSurChargePercentage;

    public ResidentialConnection(Meter meter, double fuelSurChargePercentage) {

        super(meter, fuelSurChargePercentage);
    }

    public double energyCharge() {

    }
}