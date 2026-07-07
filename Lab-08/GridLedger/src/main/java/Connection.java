public abstract class Connection {
    protected Meter meter;
    protected double fuelSurchargePercent;
    private static double TAX_PERCENT;

    protected Connection(Meter meter){
        this.meter = meter;
        this.fuelSurchargePercent = 0;
    }
    protected Connection(Meter meter, double fuelSurchargePercent){
        this.meter = meter;
        this.fuelSurchargePercent = fuelSurchargePercent;
    }


}
