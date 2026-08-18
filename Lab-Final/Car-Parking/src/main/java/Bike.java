public class Bike extends Vehicle {
    private static final Slot[] order={Slot.BIKE,Slot.REGULAR,Slot.LARGE};
     public Bike(String numPlate, Scheme scheme){
         super(numPlate,scheme);
     }
    @Override
    public Slot[] prefferedorder() {
        return order;
    }
}
