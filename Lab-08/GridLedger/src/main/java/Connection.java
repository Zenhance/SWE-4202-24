public abstract class Connection {
    private final Meter meter;
    private double fuelPercent = 0.10;
    private static final double TAX_RATE = 0.05;

    public Connection(Meter meter){
        if(meter==null){
            throw new IllegalAccessException("Meter cannot be null");
        }
        this.meter = meter;
    }
}
