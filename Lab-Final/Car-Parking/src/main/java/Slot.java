public final class Slot {
    private final SlotKind kind;
    private Vehicle vehicle;

    public Slot(SlotKind kind) {
        this.kind = kind;
    }

    public SlotKind kind() {
        return kind;
    }

    public Vehicle vehicle() {
        return vehicle;
    }

    public boolean isFree() {
        return vehicle == null;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int bill(int hours) {
        int originalBill = kind.price(
                hours,
                vehicle.ownSlotKind()
        );

        return vehicle.discount().apply(originalBill);
    }

    public void removeVehicle() {
        vehicle = null;
    }
}
