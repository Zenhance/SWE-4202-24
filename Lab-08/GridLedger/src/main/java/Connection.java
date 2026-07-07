abstract class Connection {

    public double energyCharge() {
        return 0.0;
    }

    public double fixedCharge() {
        return 0.0;
    }

    public double fuelSurcharge() {
        return 0.0;
    }

    public double tax() {
        return 0.0;
    }

    public double total() {
        return energyCharge() == 0.0 ? 0.0 : energyCharge() * 0.1 + fixedCharge() + fuelSurcharge() + tax();
    }

}
