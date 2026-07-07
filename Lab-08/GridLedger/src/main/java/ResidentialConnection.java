public class ResidentialConnection extends Connection {
    private static final int FIRST_LIMIT = 50;
    private static final int SECOND_LIMIT = 200;
    private static final double FIRST_RATE = 4.0;
    private static final double SECOND_RATE = 7.0;
    private static final double THIRD_RATE = 11.0;
    private static final double FIXED_CHARGE = 100.0;

    public ResidentialConnection(Meter meter){
        super(meter);
    }
    @Override
    public double energyCharge() {
        int units = unitsConsumed();

        if (units <= FIRST_LIMIT) {
            return units * FIRST_RATE;
        }

        if (units <= SECOND_LIMIT) {
            return FIRST_LIMIT * FIRST_RATE
                    + (units - FIRST_LIMIT) * SECOND_RATE;
        }

        return FIRST_LIMIT *FIRST_RATE+ (SECOND_LIMIT - FIRST_LIMIT) *SECOND_RATE
                +(units -SECOND_LIMIT)* THIRD_RATE;
    }

    @Override
    public double fixedCharge() {
        return FIXED_CHARGE;
    }
}