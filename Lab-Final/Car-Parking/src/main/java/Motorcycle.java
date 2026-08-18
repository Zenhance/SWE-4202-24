public class Motorcycle extends Vehicle{
    public Motorcycle(String plate, Scheme scheme){
        super(plate,scheme);
    }
    SlotKind[] acceptOrder() {
        return new SlotKind[] {
                SlotKind.LARGE,SlotKind.BIKE,SlotKind.REGULAR
        };
}
}
