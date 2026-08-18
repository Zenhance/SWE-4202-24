import java.util.HashMap;
public class ParkingLot {
    private int bikeTotal, regularTotal, largeTotal;
    private int bikeFree, regularFree, largeFree;
    private HashMap<String, Vehicle> parkedVehicles = new HashMap<>();
    private int maxStayhrs;
    private int time = 0;
    private int refusedCount = 0;
    private int totalEarned = 0;

    public void setSlots(int bike, int regular, int large) {
        bikeTotal = bike;
        regularTotal = regular;
        largeTotal = large;
        bikeFree = bike;
        regularFree = regular;
        largeFree = large;
    }

    public void setMaxStay(int hrs) {
        maxStayhrs = hrs;
    }

    public void advanceTime(int hrs) {
        time += hrs;
    }

    private int getFreeSlots(SlotType type) {
        if (type == SlotType.BIKE) {
            return bikeFree;
        } else if (type == SlotType.REGULAR) {
            return regularFree;
        } else {
            return largeFree;
        }
    }

    private int takeOneSlot(SlotType type) {
        if (type == SlotType.BIKE) {
            bikeFree = bikeFree - 1;
        } else if (type == SlotType.REGULAR) {
            regularFree = bikeFree - 1;
        } else {
            largeFree = largeFree - 1;
        }
    }
private void returnOneSlot(SlotType type){
    if(type==SlotType.BIKE){
        bikeFree=bikeFree+1;
    }
    else if(type==SlotType.REGULAR){
        regularFree=regularFree+1;
    }
    else{
        largeFree=largeFree+1;
    }
}
public void register(Vehicle vehicle){
    SlotType[] choices=vehicle.slotPreference();
    for(int i=0;i<choices.length;i++){
        SlotType type=choices[i];
        if(getFreeSlots(type)>0){
        takeOneSlot(type);
        vehicle.park(type,time);
        parkedVehicles.put(vehicle.getPlate(),vehicle);
        return;
        }
    }
    refusedCount=refusedCount+1;
}
public SlotType slotOf(String plate){
       Vehicle v=parkedVehicles.get(plate);
       if(v==null){
           return null;
       }
       return v.getKeptSlot();
    }
    public int freeCount(SlotType type){
        return getFreeSlots(type);
    }
    public int parkedCount(){
        return parkedVehicles.size();
    }
    public int refusedCount(){
        return refusedCount;
    }
    public int totalEarned(){
        return totalEarned;
    }
    public Integer billFor(String plate){
        Vehicle v=parkedVehicles.get(plate);
        if(v==null){
            return null;
        }
        int hoursParked=time-v.getEntryTime();
        return calculateFee(v,hoursParked);
    }
    public Integer leave(String plate){
        Vehicle v=parkedVehicles.remove(plate);
        if(v==null){
            return null;
        }
        int hoursParked=time-v.getEntryTime();
        int fee=calculateFee(v,hoursParked);
        totalEarned=totalEarned+fee;
        returnOneSlot(v.getKeptSlot());
        return fee;
    }

}
