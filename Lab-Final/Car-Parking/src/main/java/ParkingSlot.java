package parking ;
public class ParkingSlot{
    private SlotType type;
    private Vehicle vehicle;
    public ParkingSlot(SlotType type){
        this.type = type;
    }
    public SlotType getType(){
        return type;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
    public boolean isFree(){
        return vehicle == null;
    }
    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
        public void leave(){
            this.vehicle = null;
    }
}

