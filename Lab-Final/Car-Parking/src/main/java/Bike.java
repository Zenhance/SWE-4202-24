public class Bike extends Vehicle{
    public Bike(String plate,Category category){
        super(plate,category);
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
        return 10;
    }

}