public abstract class Vehicle {
    public final String plate;
    public int hoursStood;
    public final SlotKind slot;
    public final Scheme scheme;

    Vehicle(String plate, int hoursStood,SlotKind slot,Scheme scheme){
        this.plate=plate;
        this.hoursStood=hoursStood;
        this.slot=slot;
        this.scheme=scheme;
    }
    abstract SlotKind[] acceptOrder();
    SlotKind ownKind(){
        return acceptOrder()[0];
    }
}
