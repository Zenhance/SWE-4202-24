public class Truck extends Vehicle{
    public Truck(String Vehicleplate,Category category){
        super(Vehicleplate,category);
    }
    @Override
    public slotType[] prefferedSlot() {
        return new slotType[]{
                slotType.LARGE
        };
    }
    @Override
    public int hourlyRate(){
        return 15;
    }
}