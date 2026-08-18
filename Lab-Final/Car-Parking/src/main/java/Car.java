public class Car extends Vehicle {
    public Car(String plate, Scheme scheme) {
        super(plate, scheme);
    }

    SlotKind[] acceptOrder() {
        return new SlotKind[] { SlotKind.REGULAR, SlotKind.LARGE };
    }
}
