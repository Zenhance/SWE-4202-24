public class ResidentialConnection extends Connection {

    protected Meter meter;
    private double fuelSurChargePercentage;

    public ResidentialConnection(Meter meter, double fuelSurChargePercentage) {

        super(meter, fuelSurChargePercentage);
    }


    @Override
    public double energyCharge() {
        double unit = meter.getUnitsConsumed();
        double charge = 0;

        if (unit<=50) {
            charge += unit*4.0;

        }
        else if (unit > 50 && unit<=200 ) {
            charge += unit*7.0;
        }

        else {
            charge += unit*11.0;
        }
        return charge;
    }





}