public class Truck extends Vehicle{
    public Truck(String plate, Discount discount){
        super(plate,discount);
    }
    @Override
    public SlotType[] getWantedSlots(){
        SlotType[] a = {SlotType.LARGE};
        return a;
    }
}
