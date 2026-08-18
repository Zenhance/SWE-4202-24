public class Bike extends Vehicle{
    public Bike(String vehiclePlate,Category category){
        super(vehiclePlate,category);
    }
    @Override
    public SlotType[] slotpreference(){
        return new SlotType[]{
                SlotType.BIKE,
                SlotType.REGULAR,
                SlotType.LARGE
        };
    }
    @Override
    public int hourlyRate(){
        return 5;
    }
}
