public class Slot {
    private SlotType slot;
    private VehicleType vehicle;
    private boolean isOccupied;
    private String regName;

    public Slot(SlotType slot, VehicleType vehicle, boolean isOccupied, String  regName){
        this.slot=slot;
        this.vehicle=vehicle;
        this.isOccupied=false;
        this.regName=regName;
    }

    public Slot(SlotType slot) {
        this.slot = slot;
    }
}
