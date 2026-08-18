public class Truck extends Vehicle{
    public Truck(String plate,Category category){
        super(plate,category);
    }
    @Override
    public SlotType[] prefferedSlot(){
        return new SlotType[]{
                SlotType.LARGE
        };
    }
}
