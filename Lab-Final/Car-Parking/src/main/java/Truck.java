public class Truck extends Vehicle{
    public Truck(String plate, Scheme scheme){
        super(plate,scheme);
    }
    SlotKind[] acceptOrder(){
        return new SlotKind[]{
                SlotKind.LARGE
        };
    }
}
