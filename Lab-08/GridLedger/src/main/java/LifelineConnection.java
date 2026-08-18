public class LifelineConnection extends ResidentialConnection {

    public LifelineConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double energyCharge() {
        // Appelle la méthode de ResidentialConnection et applique le rabais
        return super.energyCharge() * 0.70;
    }
}

