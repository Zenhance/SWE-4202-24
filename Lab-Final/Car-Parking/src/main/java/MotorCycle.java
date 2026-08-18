public class MotorCycle extends Vehicle{
    public MotorCycle(String plate, Scheme scheme){
        super(plate,scheme);
    }
    SlotKind[] acceptOrder(){
        return new SlotKind[]{
                SlotKind.LARGE,SlotKind.BIKE,SlotKind.REGULAR
        };
    }
}
