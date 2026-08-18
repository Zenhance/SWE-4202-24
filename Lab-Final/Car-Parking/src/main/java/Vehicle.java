import java.util.List;

public abstract class Vehicle {
    private final String plate;
    private final DiscountScheme scheme;
    private int hoursStood;
    private SlotType currentSlot;

    public Vehicle(String plate, DiscountScheme scheme) {
        this.plate = plate;
        this.scheme = scheme;
        this.hoursStood = 0;
        this.currentSlot = null;
    }

    public abstract List<SlotType> acceptanceOrder();

    public SlotType homeSlot(){
        return acceptanceOrder().get(0);
    }
    public String getPlate(){
        return plate;
    }
    public DiscountScheme getScheme(){
        return scheme;
    }
    public int addHours(int hours){
        return this.hoursStood += hours;
    }
    public SlotType getCurrentSlot(){
        return currentSlot;
    }
    public void setCurrentSlot(SlotType currentSlot){
        this.currentSlot = currentSlot;
    }
}
