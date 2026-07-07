public abstract class Connection {
    public Meter meter;

    public abstract double energyCharge();

    public double fixedCharge(double x) {
        return x;
    }

    public double fuel(double x) {
        return x;
    }

    public double tax (double x) {
        return ((energyCharge()+fixedCharge()+fuel())*0.5);
    }
}
