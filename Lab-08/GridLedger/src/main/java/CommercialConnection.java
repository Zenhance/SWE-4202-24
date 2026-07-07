public class CommercialConnection extends Connection{
    public CommercialConnection(Meter M){
        super(M);
    }

    private double RATE_1 = 9.0;
    private double RATE_2 = 13.0;

    @Override
    public double energyCharge() {
        double c = 0;
        if (units <= 100) {
            c += units * RATE_1;
        } else {
            c += 100 * RATE_1;
            c += (units - 100) * RATE_2;
        }
        return c;
    }

    @Override
    public double fixedCharge() {
        return 500.0;
    }

}
