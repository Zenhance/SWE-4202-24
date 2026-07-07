public abstract class Connection{

    private Meter meter;

    public Connection(Meter meter) {
        this.meter = meter;
    }

    public abstract double energyCharge();
}
