public class Car extends Vehicle {
    public Car(String plate, Category category) {
        super(plate, category);
    }

    @Override
    public SlotType[] prefferedSlot() {
        return new SlotType[]{
                SlotType.REGULAR,
                SlotType.LARGE
        };
    }
    @Override
    public int hourlyRate(){
        return 20;
    }
}
