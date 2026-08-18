import exceptions.ParkingException;
import exceptions.SlotFullException;
import model.Slot;
import model.Vehicle;

import java.util.ArrayList;

public class ParkingLot {
    ArrayList<Slot> slots = new ArrayList<Slot>();
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();


    int time = 0;
    int maxStay;
    private int earned = 0;
    private int refused = 0;
    public int getEarned() {
        return earned;
    }
    public int getRefused() {
        return refused;
    }

    public ParkingLot(int bike, int regular, int large) {
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

    public void setMaxStay(int maxStay) {
        if(maxStay<=0){
            throw new IllegalArgumentException();
        }
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

    public void arrive(Vehicle vehicle) throws ParkingException {
        if(findVehicle(vehicle.getLicencePlate()) != null) {
            throw new IllegalStateException();
        }
        if(vehicle.getLicencePlate().equals("-")){
            //refused++;
            throw new ParkingException();
        }
        Slot slot = findFreeSlot(vehicle);
        if(slot == null){
            //refused++;
            throw new SlotFullException();
        }
        slot.park(vehicle);
        vehicles.add(vehicle);
        vehicle.setEntryTime(time);
    }

    Vehicle findVehicle(String plate){
        for(Vehicle v: vehicles){
            if(v.getLicencePlate().equals(plate)){
                return v;
            }
        }
        return null;
    }
    Slot findSlot(String plate){
        for(Slot s: slots){
            if(!s.free() && s.getVehicle().getLicencePlate().equals(plate)){
                return s;
            }
        }
        return null;
    }

    public int calculate(Vehicle v, Slot s, int hours){
        int total = s.getFirstHourCHarge() + (hours-1)* s.getExtraHourCHarge();
        if(!s.getType().equals(v.bestSlot())){
            total += s.getSurcharge();
        }

        if(v.getPermit().equals("STUDENT")){
            total -= 20/total*100;
        }
        if(v.getPermit().equals("WEEKEND")){
            total = Math.max(0, total-10);
        }
        return total;
    }

    public int bill(String plate){
        Vehicle v = findVehicle(plate);
        if(v == null){
            return -1;
        }
        Slot s = findSlot(plate);

        int hours = time - v.getEntryTime();

        return calculate(v, s, hours);
    }

    public void leave(String plate) throws ParkingException {
        Vehicle v = findVehicle(plate);
        if(v == null){
            throw new ParkingException();
        }

        Slot s = findSlot(plate);

        earned += bill(plate);

        s.remove();
        vehicles.remove(v);
    }

    public void evict(String plate) throws ParkingException {
        Vehicle v = findVehicle(plate);
        if(v == null){
            throw new ParkingException();
        }
        Slot s = findSlot(plate);
        //earned += *eviction bill calc*
        earned += bill(plate);
        s.remove();
        vehicles.remove(v);
    }

    public int free(String type){
        int count = 0;
        for(Slot s: slots){
            if(s.getType().equals(type)&&s.free()){
                count++;
            }
        }
        return count;
    }

    public void passtime(int hours) throws ParkingException {
        time += hours;
        /*ArrayList<Vehicle> removed = new ArrayList<>();

        for(Vehicle v: vehicles){
            if(time - v.getEntryTime()>maxStay){
                evict(v.getLicencePlate());
                removed.add(v);
            }
        }*/
    }

    public int count(){
        int count = 0;
        for(Slot s: slots){
            if(s.free()){
                count++;
            }
        }
        return count;
    }

    public void refusedCount(){
        refused++;
    }
}
