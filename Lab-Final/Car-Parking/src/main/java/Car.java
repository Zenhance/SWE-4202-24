import java.util.List;

public abstract class Car extends Vehicle {
    public Car(String plate,DiscountScheme scheme){
        super(plate, scheme);
    }

    @Override
    public List<SlotType> acceptanceOrder(){
        return List.of(SlotType.REGULAR,SlotType.LARGE);
    }
}
