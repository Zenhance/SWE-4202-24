public class ResidentialConnection extends Connection {
    public ResidentialConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double energyCharge() {
        int units = getUnits();
        if (units <= 50) {
            return units * 4.0;
        }
        if (units <= 200) {
            return (50 * 4.0) + ((units - 50) * 7.0);
        }
        return (50 * 4.0) + (150 * 7.0) + ((units - 200) * 11.0);
    }

}
