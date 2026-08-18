import java.util.List;

public abstract class Vehicle {
    private final String plate;
    private final DiscountScheme scheme;
    private int hoursStood;
    private SlotType currentSlot;

    public Vehicle(String plate,DiscountScheme scheme){
        this.plate=plate;
        this.scheme=scheme;
        this.hoursStood=0;
        this.currentSlot=null;
    }

    public abstract List<SlotType> acceptanceOrder();
}
