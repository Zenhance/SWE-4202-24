public class ResidentialConnection extends Connection {


    public ResidentialConnection(Meter meter) {
        super(meter);

    }

    @Override
    public double fixedCharge() {
        return 100.0;
    }

    /*
    public double fuelSurcharge() {

        return energyCharge()*fuelPercent;
    }
    public double tax(){
        return (energyCharge()+fuelSurcharge()+fixedCharge())*taxPercent;
    }
*/

    public double energyCharge() {
        int units = meter.getEndingunit() - meter.getStartingunit();
        double c = 0;
        if (units <= 50) {
            c += units * 4.0;
        } else {
            c += 50 * 4.0;
            if (units <= 200) {
                c += (units - 50) * 7.0;
            } else {
                c += 150 * 7.0;
                c += (units - 200) * 11.0;
            }
        }
        return c;
    }
}
