public class Truck class Truck extends Vehicle {

    public Truck(String plate, String scheme) {
        super(plate, scheme);
    }

    @Override
    public SlotType[] getAcceptedSlots() {
        return new SlotType[] {
                SlotType.LARGE
        };
    }
}
