public class CommercialConnection extends Connection{

    public CommercialConnection(Meter meter) {
        this.meter=meter;    }

    @Override
    public double energyCharge() {
        double c = 0;
        int units= meter.getUnitsConsumed();
        if (units <= 100) {
            c += units * 9.0;
        } else {
            c += 100 * 9.0;
            c += (units - 100) * 13.0;
        }
        return c;
    }
    @Override
    public double fixedCharge() {
        return 500;
    }
    /*@Override
    public double fuelSurcharge() {

        return energyCharge()*fuelPercent;
    }*/

}
