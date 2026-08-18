public class Bike extends Vehicle{
    public Bike(String plate,Category category){
        super(plate,category);
    }
    @Override
    public SlotType[] prefferedSlot(){
        return new SlotType[]{
                SlotType.BIKE,
                SlotType.REGULAR,
                SlotType.LARGE
        };
    }

}
