public class Car extends Vehicle {
    public Car(String vehiclePlate, Category category) {
        super(vehiclePlate, category);
    }

    @Override
    public SlotType[] slotpreference() {
        return new SlotType[]{
                SlotType.REGULAR,
                SlotType.LARGE
        };
    }

    @Override
    public int hourlyRate() {
        return 10;
    }
}
