public abstract class Vehicle {
    final String plate;
    int hoursStood;
    SlotKind slot;
    final Scheme scheme;

    Vehicle(String platte) {
        this.plate = plate;
        this.hoursStood = 0;
        this.scheme = scheme;
    }

    abstract SlotKind[] acceptOrder();

    SlotKind ownKind() {
        return acceptOrder()[0];
    }
}