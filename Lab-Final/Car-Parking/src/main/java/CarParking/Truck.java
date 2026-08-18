package CarParking;

public final  class Truck extends AbstractVehicle {
    public Truck(String plate,DiscountPolicy discountPolicy){
        super(plate,discountPolicy);
    }
    @Override
    public SlotKind preferredKind(){
        return SlotKind.LARGE;
    }
    @Override
    public boolean accepts(SlotKind kind){
        return kind==SlotKind.LARGE;
    }
}
