public class Car extends Vehicle {

    public Car(String plate, String scheme) {
        super(plate, scheme);
    }

    @Override
    public SlotType[] getAcceptedSlots() {
        return new SlotType[] {
                SlotType.REGULAR,
                SlotType.LARGE
        };
    }
}
