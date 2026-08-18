public class Vehicle {
    public final VehicleKind kind;
    public final SlotKind slot;
    public final int parkedAt;

    Vehicle(VehicleKind kind, SlotKind slot, int parkedAt){
        this.kind=kind;
        this.slot=slot;
        this.parkedAt=parkedAt;
    }
}
