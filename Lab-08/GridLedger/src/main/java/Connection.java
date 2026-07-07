public abstract class Connection {
    private Meter meter;

    public Connection(Meter meter){
        this.meter = meter;
    }

    public abstract double energyCharge();

    public abstract double fixedCharge();

    public abstract double fuelSurcharge();

    public abstract double tax();

    public abstract double total();

}
