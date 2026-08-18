public class Car extends Vehicle {
    public Car(String Vehicleplate, Category category) {
        super(Vehicleplate, category);
    }

    @Override
    public slotType[] prefferedSlot() {
        return new slotType[]{
                slotType.REGULAR,
                slotType.LARGE
        };

    }
    @Override
    public int hourlyRate(){
        return 10;
    }
}





