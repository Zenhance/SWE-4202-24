package CarParking;

public final class Car extends AbstractVehicle {
    public Car(
            String plate, DiscountPolicy discountPolicy){
        super(plate,discountPolicy);
    }
    @Override
    public SlotKind preferredKind(){
        return SlotKind.REGULAR;
    }
    @Override
    public boolean accepts(SlotKind kind){
        return kind==SlotKind.REGULAR
                || kind==SlotKind.LARGE;
    }
}
