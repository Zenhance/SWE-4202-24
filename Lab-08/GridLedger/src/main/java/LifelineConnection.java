public class LifelineConnection extends ResidentialConnection{

    public LifelineConnection(Meter meter) {
        super(meter);
    }
    public LifelineConnection(Meter meter, double surChargePercent){
        super(meter, surChargePercent);
    }
}
