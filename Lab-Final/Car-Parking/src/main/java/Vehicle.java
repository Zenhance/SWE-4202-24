public class Vehicle {
    private final String plate;
    private int hoursStood;
    private SlotType currentSlot;
    public Vehicle(String plate, DiscountScheme scheme){
this. plate=plate;
this.scheme=scheme;
this. hoursStood= 0;
this.currentSlot=null;
    }
    public abstract list<SlotType>acceptanceOrder();
    public SlotType homeSlot(){
        return acceptanceOrder.get(0);
    }
    public String getPlate(){
        return plate;
    }
    public int getDiscountScheme (){
        return scheme;
    }
    public int  getHoursStood (){
        return hoursStood;
    }
    public SlotType getCurrentSlot (){
        return currentSlot;
    }

}
