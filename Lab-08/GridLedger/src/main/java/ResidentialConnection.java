public class ResidentialConnection extends Connection {
    public ResidentialConnection(Meter meter){
        super(meter);
    }

    @Override
    public double energyCharge(){
        double c = 0;
        if (meter.getUnitsConsumed() <= 50) {
            c += meter.getUnitsConsumed() * 4.0;
        } else {
            c += 50 * 4.0;
            if (meter.getUnitsConsumed() <= 200) {
                c += (meter.getUnitsConsumed() - 50) * 7.0;
            } else {
                c += 150 * 7.0;
                c += (meter.getUnitsConsumed() - 200) * 11.0;
            }
        }
        return c;
    }

    @Override
    public double fixedCharge() {
        return 100.0;
    }
}
