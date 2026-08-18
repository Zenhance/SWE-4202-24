public abstract class Vehicle {
    private final String plate;
    private Slot slotType;
    private int timeStayed;
    private static int maxTimeStay;
    private boolean isParked;

    protected Vehicle(String plate) {
        this.plate = plate;
        this.timeStayed = 0;
        isParked = false;
    }

    public void setSlotType(Slot slotType) {
        if (slotType == null)
            throw new IllegalArgumentException("Preferred slot type cannot be null");
        this.slotType = slotType;
    }

    public int getTimeStayed() {
        return timeStayed;
    }

    public static void setMaxTimeStay(int maxTimeStay) {
        if (maxTimeStay <= 0)
            throw new IllegalArgumentException("Max time stay cannot be neagtive or zero");
        Vehicle.maxTimeStay = maxTimeStay;
    }

    public int getMaxTimeStay() {
        return maxTimeStay;
    }

    public void park() {
        isParked = true;
    }
}
