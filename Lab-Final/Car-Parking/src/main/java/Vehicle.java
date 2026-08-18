public abstract class Vehicle {
    private final String plate;
    private Slot preferredType;
    private int timeStayed;

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
}
