import java.util.HashMap;

public class Parkinglot {
    //total slots
    private int bikeTotal;
    private int regularTotal;
    private int largeTotal;
    //slots still free
    private int bikeFree;
    private int regularFree;
    private int largeFree;

    private HashMap<String,Vehicle>parkedVehicles = new HashMap<>();
    private int maxStayhrs;
    private int time=0;
    private int refusedCount=0;
    private int totalEarned=0;

public void setSlots(int bike,int regular,int large){
    bikeTotal=bike;
    regularTotal=regular;
    largeTotal=large;
    regularFree=regular;
    largeFree=large;
}
public void setMaxStay(int hrs) {
    maxStayhrs = hrs;
}
public void advanceTime(int hrs){
    currentTime+=hrs;
}
private int getFreeSlots(SlotType type){
    if(type==SlotType.BIKE){
        return bikeFree;
    }
    else if(type==SlotType.REGULAR){
        return regularFree;
    }
    else{
        return largeFree;
    }
}
private void takeOneSlot(SlotType type) {
    if (type == SlotType.BIKE) {
        bikeFree = bikeFree - 1;
    } else if (type == SlotType.REGULAR) {
        regularFree = regularFree - 1;
    } else {
        largeFree = largeFree - 1;
    }
}


