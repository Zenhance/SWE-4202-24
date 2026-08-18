package Parking;

import Slot.Slot;
import Slot.SlotType;

import Vehicle.Vehicle;
import Slot.DiscountScheme;
import Exception.NoPlateException;
import Exception.NoSlotException;
import Exception.UnknownPlateException;
import java.util.ArrayList;

public class CarPark {
    private ArrayList<Slot> slots;
    private ArrayList<Vehicle> vehicles;

    private int maxStay;
    private int currentTime;

    private int earned;
    private int refused;



    public CarPark(ArrayList<Slot> slots, int maxStay){
        if(slots==null){
            throw new IllegalArgumentException("slots cannot be null");
        }
        if(maxStay<0){
            throw new IllegalArgumentException("Maximum stay cannot be less than 0");
        }
        this.slots=slots;
        this.maxStay=maxStay;
        this.vehicles=new ArrayList<>();

        this.currentTime=0;
        this.earned=0;
        this.refused=0;

    }

    private Slot findAvailableSlot(Vehicle vehicle){
        SlotType[] acceptedTypes = vehicle.getAcceptedSlotTypes();
        for(SlotType type: acceptedTypes){
            for(Slot slot: slots){
                if(slot.getType()== type && slot.isFree()){
                    return slot;
                }
            }
        }

        return null;
    }

    public void parkVehicle(Vehicle vehicle) throws NoPlateException, NoSlotException {
        if(vehicle==null || vehicle.getNumberPlate()==null || vehicle.getNumberPlate().isBlank()){
            throw new NoPlateException("Vehicle has no plate");
        }

        Slot slot= findAvailableSlot(vehicle);
        if(slot==null){
            throw new NoSlotException("No suitable slot found");
        }
        vehicle.setEntryTime(currentTime);

        slot.park(vehicle);
        vehicles.add(vehicle);

    }

    private Vehicle findVehicle(String plate){
        for(Vehicle vehicle: vehicles ){
            if(vehicle.getNumberPlate().equals(plate)){
                return vehicle;
            }
        }
        return null;
    }

    private Slot findSlot(Vehicle vehicle){
        for(Slot slot: slots){
            if(slot.getVehicle()==vehicle){
                return slot;
            }
        }
        return null;
    }

    private int calculateBaseBill(Slot slot, int hours){
        if(hours<1){
            hours=1;
        }
        int firsthour;
        int furtherhour;
        int surcharge=0;

        if(slot.getType()==SlotType.BIKE){
            firsthour=10;
            furtherhour=5;
        }else if(slot.getType()==SlotType.REGULAR){
            firsthour=30;
            furtherhour=20;
            surcharge=15;
        }else{
            firsthour=50;
            furtherhour=40;
            surcharge=25;
        }
        return firsthour+(hours-1)*furtherhour+surcharge;
    }


    private int applyDiscount(int bill,  DiscountScheme discountScheme){
        if(discountScheme== DiscountScheme.NONE){
            return bill;
        }

        if(discountScheme==  DiscountScheme.STUDENT){
            return bill-(bill*20/100);
        }
        if(discountScheme==  DiscountScheme.WEEKEND){
            return Math.max(0, bill-10);
        }

        return bill;
    }

    public int getBill(String plate) throws UnknownPlateException {
        Vehicle vehicle = findVehicle(plate);

        if (vehicle == null) {
            throw new UnknownPlateException("Unknown plate");
        }

        Slot slot = findSlot(vehicle);

        int hours = currentTime - vehicle.getEntryTime();

        int bill = calculateBaseBill(slot, hours);

        return applyDiscount(bill, vehicle.getDiscountScheme()  );
    }
    public SlotType getSlotType(String plate)
            throws UnknownPlateException {

        Vehicle vehicle = findVehicle(plate);

        if (vehicle == null) {
            throw new UnknownPlateException("Unknown plate");
        }

        Slot slot = findSlot(vehicle);

        return slot.getType();
    }

    public int leaveVehicle(String plate)
            throws UnknownPlateException {

        Vehicle vehicle = findVehicle(plate);

        if (vehicle == null) {
            throw new UnknownPlateException("Unknown plate");
        }

        Slot slot = findSlot(vehicle);

        int bill = getBill(plate);

        slot.removeVehicle();
        vehicles.remove(vehicle);

        earned += bill;

        return bill;
    }

    public void passTime(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException(
                    "Time cannot be negative"
            );
        }

        currentTime += hours;

        ArrayList<Vehicle> toRemove = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            int stay = currentTime - vehicle.getEntryTime();

            if (stay >= maxStay) {
                Slot slot = findSlot(vehicle);

                int bill = calculateBaseBill(slot, maxStay);

                int removalHours = (maxStay + 9) / 10;

                int furtherHour;

                if (slot.getType() == SlotType.BIKE) {
                    furtherHour = 5;
                } else if (slot.getType() == SlotType.REGULAR) {
                    furtherHour = 20;
                } else {
                    furtherHour = 40;
                }

                bill += furtherHour * removalHours;

                bill = applyDiscount(
                        bill,
                        vehicle.getDiscountScheme()
                );

                earned += bill;

                slot.removeVehicle();
                toRemove.add(vehicle);
            }
        }

        vehicles.removeAll(toRemove);
    }

    public int getFreeSlots(SlotType type) {
        int count = 0;

        for (Slot slot : slots) {
            if (slot.getType() == type && slot.isFree()) {
                count++;
            }
        }

        return count;
    }

    public int getVehicleCount() {
        return vehicles.size();
    }

    public int getEarned() {
        return earned;
    }

    public int getRefused() {
        return refused;
    }

    public void incrementRefused() {
        refused++;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public int getMaxStay() {
        return maxStay;
    }



}
