public class ResidentialConnection extends Connection {

    private Meter meter;

    public ResidentialConnection(Meter meter) {
        super(meter);
    }

    public ResidentialConnection() {

    }

    @Override
    public double energyCharge() {

        int units = meter.getUnitsConsumed();

        double charge = 0;

        if (units <= 50) {
            charge = units * 4;
        }
        else if (units <= 200) {
            charge = 50 * 4;
            charge += (units - 50) * 7;
        }
        else {
            charge = 50 * 4;
            charge += 150 * 7;
            charge += (units - 200) * 11;
        }

        return charge;
    }

    @Override
    public double fixedCharge() {
        return 100;
    }
}