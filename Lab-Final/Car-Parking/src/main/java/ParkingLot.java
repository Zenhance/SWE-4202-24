import exceptions.ParkingRefusedException;
import exceptions.SlotFullException;
import model.Slot;
import model.Vehicle;

import java.util.ArrayList;

public class ParkingLot {
    ArrayList<Slot> slots = new ArrayList<Slot>();
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();


    int time = 0;
    int maxStay;
    int earned = 0;
    int refused = 0;

    ParkingLot(int bike, int regular, int large) {
        for(int i = 0; i < bike; i++) {
            slots.add(new Slot("BIKE"));
        }
        for(int i = 0; i < regular; i++) {
            slots.add(new Slot("REGULAR"));
        }
        for(int i = 0; i < large; i++) {
            slots.add(new Slot("LARGE"));
        }
    }

    void setMaxStay(int maxStay) {
        this.maxStay = maxStay;
    }

    Slot findFreeSlot(Vehicle vehicle) {
        for(String type: vehicle.slotOrder()){
            for(Slot slot: slots){
                if((slot.getType().equals(type))&&slot.free()){
                    return slot;
                }
            }
        }
        return null;
    }

    public void arrive(Vehicle vehicle) {
        Slot slot = findFreeSlot(vehicle);
        if(slot == null){
            throw new SlotFullException("");
        }
        slot.park(vehicle);
        vehicles.add(vehicle);
        vehicle.setEntryTime(time);
    }
}
