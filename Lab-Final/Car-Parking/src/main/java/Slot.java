public class Slot {
    private final SlotKind kind;
    private final int firstHourRate;
    private final int nextHourRate;
    private final int surcharge;

    public Slot(SlotKind kind, int firstHourRate, int nextHourRate, int surcharge) {
        this.kind = kind;
        this.firstHourRate = firstHourRate;
        this.nextHourRate = nextHourRate;
        this.surcharge = surcharge;
    }

    public SlotKind getKind() {
        return kind;
    }

    public int getNextHourRate() {
        return nextHourRate;
    }

    public int calculateRawBill(Vehicle vehicle, int hoursStood) {
        int billedHours = Math.max(1, hoursStood);
        int baseFee = firstHourRate + (billedHours - 1) * nextHourRate;

        if (vehicle.getHomeSlotKind() != this.kind) {
            baseFee += surcharge;
        }
        return baseFee;
    }
}