public class Slot {
    private final SlotKind kind;
    private Vehicle parkedVehicle;

    public Slot(SlotKind kind) {
        this.kind = kind;
    }

    public boolean isFree() {
        return false;
    }

    public SlotKind getKind() {
        return kind;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle vehicle) {
    }

    public int firstHourFee() {
        return 0;
    }

    public int furtherHourFee() {
        return 0;
    }

    public int surcharge() {
        return 0;
    }
}
