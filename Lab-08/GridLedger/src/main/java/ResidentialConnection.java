public class ResidentialConnection extends Connection {

    residentialConnection(Meter meter){
        super(meter);
    }

    double energCharge() {
        int unit = meter.unitconsumed();
        double charge = 0;

        if (unit <= 50) {
            charge = unit * 4.0;
        } else if (unit <= 200) {
            charge = unit * 4.0;
            charge += (units - 50) * 7.0;
        } else {
            charge = 50 * 4.0;
            charge += 150 * 7.0;
            charge += (unit - 200) * 11.00;
        }
        return charge;


        double fixedCharge () {
            return 50;
        }
    }

}
