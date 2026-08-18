public class Bike extends Vehicle{
    public Bike(String plate, Discount discount){
        super(plate,discount);
    }
    @Override
    public SlotType[] getWantedSlots(){
        SlotType[] a = {SlotType.BIKE, SlotType.REGULAR, SlotType.LARGE};
        return a;
    }
}
