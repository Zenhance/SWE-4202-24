public class Bike extends Vehicle{
    public Bike(String Vehicleplate,Category category){
        super(Vehicleplate,category);
    }
    @Override
    public slotType[] prefferedSlot(){
        return new slotType[]{
                slotType.BIKE,
                slotType.REGULAR,
                slotType.LARGE
        };
    }
    @Override
    public int hourlyRate(){
        return 5;
    }

}