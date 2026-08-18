public class Car extends Vehicle{
    public Car(String plate, Discount discount){
        super(plate,discount);
    }
    @Override
    public SlotType[] getWantedSlots(){
        SlotType[] a = {SlotType.REGULAR, SlotType.LARGE};
        return a;
    }
}
