import java.util.List;
public abstract class Vehicle {
    private final String plate;
    private int hoursStood;
    private SlotType currentSlot;
    private DiscountScheme scheme;
    public Vehicle(String plate, DiscountScheme scheme){
this. plate=plate;
this.scheme=scheme;
this. hoursStood= 0;
this.currentSlot=null;
    }
    public abstract List<SlotType>acceptanceOrder();
    public SlotType homeSlot(){
        return acceptanceOrder().get(0);
    }
    public String getPlate(){
        return plate;
    }
    public DiscountScheme getDiscountScheme (){
        return scheme;
    }
    public int  getHoursStood (){
        return hoursStood;
    }
    public SlotType getCurrentSlot (){
        return currentSlot;
    }

}
