import java.util.ArrayList;
import java.util.List;

public class ParkingSystem {
    VehicleType vehicleType;
    int firsthour;
    String plate;
    List<SlotBooking> slots = new ArrayList<SlotBooking>();
    List<Vehicle> vehicles = new ArrayList<Vehicle>();
    int maxStay;
    int totalearned;

    public ParkingSystem(int bike, int regular, int large) {
        for (int i=0;i<bike;i++){
            slots.add(new SlotBooking(slotsType.BIKE));
        }
        for(int i=0;i<regular;i++){
            slots.add(new SlotBooking(slotsType.REGULAR));
        }
        for (int i=0;i<large;i++){
            slots.add(new SlotBooking(slotsType.LARGE));
        }
    }

    public int firstRate(slotsType type) {
        if (type==slotsType.BIKE) {
            return 10;
        } else if(type==slotsType.REGULAR){
            return 30;
        } else {
            return 30;
        }
    }

    public int FurtherRate(slotsType type){
        if (type==slotsType.BIKE) {
            return 10;
        } else if(type==slotsType.REGULAR){
            return 30;
        } else{
            return 30;
        }
    }

    public int getSurcharge(slotsType type) {
        if (type==slotsType.BIKE) {
            return 0;
        } else if(type==slotsType.REGULAR) {
            return 15;
        } else {
            return 25;
        }
    }

    public int calculateBill(Vehicle v, boolean eviction){
        slotsType type = v.slot;
        int h = v.hours;
        if (eviction){
            h = maxStay;
        }
        int bill=firstRate(type);
        if(h>1){
            bill=bill+(h-1)*FurtherRate(type);
        }
    }
}