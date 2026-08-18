package CarParking;

public final class Bike extends  AbstractVehicle {
    public Bike(String plate, DiscountPolicy discountPolicy){
        super (plate,discountPolicy);
    }
    @Override
    public SlotKind preferredKind(){
        return SlotKind.BIKE;
    }
    @Override
    public boolean accepts(SlotKind kind){
        return kind== SlotKind.BIKE
                || kind==SlotKind.REGULAR
                || kind==SlotKind.LARGE;
    }

}
