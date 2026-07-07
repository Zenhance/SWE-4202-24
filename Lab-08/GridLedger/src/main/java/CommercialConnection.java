public class CommercialConnection extends Connection {
    @Override
    public double energyCharge() {
            if (units <= 100)
                c += units * 9.0;
            else { c += 100 * 9.0; c += (units-100) * 13.0; }
            return C;
    }
}
