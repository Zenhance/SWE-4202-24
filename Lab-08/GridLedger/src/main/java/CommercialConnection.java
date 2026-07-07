public class CommertialConnection extends Connection {

    Connection(Meter meter){
        super(meter);
    }

    double energCharge() {
        int unit = meter.unitconsumed();
        double charge;

        if (unit <= 50) {
            charge = unit * 9.0;
        }
        else (unit <= 100) {
            charge =100*9.0;
            charge += (units - 100) * 13.0;

        return charge;

        double fixedCharge () {
            return 100;
        }
    }

