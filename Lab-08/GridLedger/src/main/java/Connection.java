public abstract class Connection {
    private Meter meter;
    private double fuelPercentage=0.0;
    public Connection(Meter meter){
        if(meter==null){
            throw new IllegalArgumentException("Meter required");
        }
        this.meter=meter;
    }
}
