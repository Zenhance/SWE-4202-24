public abstract class Vehicle {
    private final String plate;
    private Slot preferredType;
    private int timeStayed;
    private int maxTimeStay;

    protected Vehicle(String plate) {
        this.plate = plate;
        this.timeStayed = 0;
    }

    public void setPreferredType(Slot preferredType) {
        if (preferredType == null)
            throw new IllegalArgumentException("Preferred slot type cannot be null");
        this.preferredType = preferredType;
    }

    public int getTimeStayed() {
        return timeStayed;
    }

    public void setMaxTimeStay(int maxTimeStay) {
        if (maxTimeStay <= 0)
            throw new IllegalArgumentException("Max time stay cannot be neagtive or zero");
        this.maxTimeStay = maxTimeStay;
    }

    public int getMaxTimeStay() {
        return maxTimeStay;
    }
}