public class ResidentialConnection extends Connection {

    public ResidentialConnection(Meter meter){
        super(meter);
    }

    @Override
    public double energyCharge() {
        int units = super.getMeter().getUnitsConsumed();
        double subtotal = 0;

        if (units <= 50)
            subtotal += units * 4.0;
        else if (units > 50 && units <= 200) {
            subtotal += ((50 * 4.0) + ((units - 50) * 7.0));
        }
        else
            subtotal += ((50 * 4.0) + (150 * 7.0) + ((units - 200) * 11.0));
        return subtotal;
    }


}
