package parking;
public class ParkingRecord{
    private Vehicle vehicle;
    private ParkingSlot slot;
    private int startTime;

    public ParkingRecord(Vehicle vehicle, ParkingSlot slot,int startTime){
        this.vehicle = vehicle;
        this.slot = slot;
        this.startTime = startTime;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
    public ParkingSlot getSlot(){
        return slot;
    }
    public int getStartTime(){
        return startTime;
    }
}
