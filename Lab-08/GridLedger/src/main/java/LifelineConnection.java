public class LifelineConnection extends ResidentialConnection{
    public LifelineConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double total() {
        return super.total()*0.7;
    }
}
