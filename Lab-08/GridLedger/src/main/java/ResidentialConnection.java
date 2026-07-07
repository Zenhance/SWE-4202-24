public class ResidentialConnection extends Connection {

    public ResidentialConnection(Meter M){
        super(M);
    }

    private double RATE_1 = 4.0;
    private double RATE_2 = 7.0;
    double RATE_3 = 11.0;
    @Override
    public double energyCharge() {
        double c = 0;
        if (units <= 50) {
            c += units * RATE_1;
        } else {
            c += 50 * RATE_1;
            if (units <= 200) {
                c += (units - 50) * RATE_2;
            } else {
                c += 150 * RATE_2;
                c += (units - 200) * RATE_3;
            }
        }
        return c;
    }

    @Override
    public double fixedCharge() {
        return 100.0;
    }
}
