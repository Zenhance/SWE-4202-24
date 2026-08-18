public class Slot {
    private final SlotKind kind;
    private Vehicle parkedVehicle;

    public Slot(SlotKind kind) {
        this.kind = kind;
    }

    public boolean isFree() {
        return parkedVehicle == null;
    }

    public SlotKind getKind() {
        return kind;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
    }
}
