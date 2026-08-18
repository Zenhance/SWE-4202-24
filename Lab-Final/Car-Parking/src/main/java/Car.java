public class Car extends Vehicle {
    public Car(String numPlate, Scheme scheme){
        super(numPlate,scheme);

    }
    private static final Slot[] order={Slot.REGULAR,Slot.LARGE};
    @Override
    public Slot[] prefferedorder() {
        return order;
    }
}
