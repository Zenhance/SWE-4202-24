public abstract class Vehicle {
    private final String plate;
    private Slot preferredType;

    protected Vehicle(String plate) {
        this.plate = plate;
    }

    public void setPreferredType(Slot preferredType) {
        if (preferredType == null)
            throw new IllegalArgumentException("Preferred slot type cannot be null");
        this.preferredType = preferredType;
    }
}