public abstract class Connection {


    protected Meter meter;
    protected double fuelPercentage = 0.10;

    public Connection(Meter meter){
        this.meter = meter;
    }


}
