public class Car extends Vehicle {
    public Car(String plate, Category category) {
        super(plate, category);
    }

    @Override
    public slotType[] prefferedSlot() {
        return new slotType[]{
                slotType.REGULAR,
                slotType.LARGE
        }





