import java.util.ArrayList;

public class CarPark {
    private ArrayList<ParkingSlot> slots;
    private ArrayList<Vehicle> vehicles;

    private int maxStay;
    private int earned;
    private int refused;


    public CarPark(int bikeSlots, int regularSlots, int largeSlots) {
        slots = new ArrayList<>();
        vehicles = new ArrayList<>();
        earned = 0;
        refused = 0;

        for (int i = 0; i < bikeSlots; i++) {
            slots.add(new ParkingSlot("BIKE"));
        }

        for (int i = 0; i < regularSlots; i++) {
            slots.add(new ParkingSlot("REGUlAR"));
        }

        for (int i = 0; i < largeSlots; i++) {
            slots.add(new ParkingSlot("Large"));
        }
    }

    public void setMaxStay(int maxStay) {
        this.maxStay = maxStay;
    }


    public void parkVehicle(Vehicle vehicles)
            throws ParkingException {
        if (vehicles.getPlate().isEmpty()) {
            throw new ParkingException("No plate");
        }
ParkingSlot freeSlot=findFreeSlot(vehicles);
if(freeSlot==null){
    throw new ParkingException("No free slot");
}
freeSlot.park(vehicles);
vehicle.setSlot(freeSlot);
vehicle.add(vehicles);
    }

    private ParkingSlot findFreeSlot(Vehicle vehicles) {
        String[] acceptedTypes = vehicles.getAcceptedSlotTypes();

        for (String wantedType : acceptedTypes) {
            for (ParkingSlot slot : slots) {
                if (slot.getType().equals(wantedType) && slot.isFree()) {
                    return slot;
                }
            }
        }
        return null;


    }

    public void passTime(int hours){
        ArrayList<Vehicle> vehiclesToRemove=new ArrayList<>();

        for(Vehicle vehicle: vehicles){
            vehicle.addHour(hours);
        }
      if(vehicle.getHours()>=maxStay){
          int bill=calculateBill(vehicles,true);
          earned=earned+bill;
          vehiclesToRemove.add(vehicles);
      }
    }

    for(Vehicle vehicle: vehiclesToRemove){
        removeVehicle(vehicles);
    }
}
public void leave(String plate) throws ParkingException{
    Vehicle vehicle=findVehicle(plate);

    if(vehicle==null){
        throw new ParkingException("Vehicle not found");
    }
    int bill=calculateBill(vehicle,false);
    earned=earned+bill;
    removeVehicle(vehicle);

    public String getBill(String plate){
        Vehicle vehicle=findVehicle(plate);

        if(vehicle==null){
            return "NONE";
        }

        int bill=calculateBill(vehicle,false);

        return String.valueOf(bill);
    }

    public String getSlotType(String plate){
        Vehicle vehicle=findVehicle(plate);

        if(vehicle==null){
            return "NONE";
        }
        return vehicle.getSlot().getType();
    }

    public int getFreeSots(String type){
        int count=0;

        for(ParkingSlot slot:slots){
            if(slot.getType().equals(type)&& slot.isFree()){
                count++;
            }
        }
        return count;
    }

public int getVehicleCount(){
        return vehicles.size();
    }

    public int getEarnes(){
        return earned;
    }

    public int getRefused(){
        return refused;
    }

    public void addRefusal(){
        refused++;
    }

    private Vehicle findVehicle(String plate){
        for(Vehicle vehicle: vehicles){
            if(vehicle.getPlate().equals(plate)){
                return vehicle;
            }
        }
        return null;

    }

    private int calculateBill(Vehicle vehicle,boolean evicted){
        ParkingSlot slot=vehicle.getSlot();
        int hours=vehicle.getHours();
        if(hours<1){
            hours=1;
        }
        if(evicted){
            hours=maxStay;
        }
        int bill=slot.getFirstHourPrice();

        if(hours>1){
            bill=bill+(hours-1)*slot.getNextHourPrice();
        }
        if(!slot.getType().equals(vehicle.getOwnSlotType())){
            bill=bill+slot.getSurcharge();
        }

        if(evicted){
            int removalHours=(maxStay+9)/10;
        }

        bill=bill+removalHours*slot.getNextHourPrice();
    }

    if(vehicle.getDiscount().equals("STUDENT")){
        int discount=20*bill/100;
        bill=bill-discount;
    } else if (vehicle.getDiscount().equals("WEEKEND")) {
        bill=bill-10;

        if(bill<0){
            bill=0;
        }
    }
    return bill;

    private void removalVehicle(Vehicle vehicle){
        ParkingSlot slot=vehicle.getSlot();

        slot.makeFree();

        vehicles.removeFree()

    }
}