public class Truck extends Vehicle {
    public Truck(String vehiclePlate, Category category) {
        super(vehiclePlate, category);
    }

    @Override
    public SlotType[] slotPreference() {
        return new SlotType[]{
                SlotType.LARGE

        };
    }

    @Override
    public int hourlyRate() {
        return 15;
    }
}
