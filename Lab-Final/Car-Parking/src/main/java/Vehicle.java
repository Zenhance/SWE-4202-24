public abstract class Vehicle {
    private final String plate;
    private Slot preferredType;

    protected Vehicle(String plate) {
        this.plate = plate;
    }
}
