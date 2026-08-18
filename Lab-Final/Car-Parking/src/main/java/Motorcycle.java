public class Motorcycle extends Vehicle {

    public Motorcycle(String plate, String scheme
    ) {
        super(plate, scheme);
    }


    @Override
    public SlotType[] getAcceptedSlots() {
        return new SlotType[] {
                SlotType.BIKE,
                SlotType.REGULAR,
                SlotType.LARGE
        };
    }
}

