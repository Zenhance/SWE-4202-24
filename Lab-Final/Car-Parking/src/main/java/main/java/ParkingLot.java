package main.java;

import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<Slot> slots;
    private int currentHour;
    private int maxStay;
    private int earned;
    private int refused;

    public ParkingLot( int bikeslots, int regular, int large, int maxStay) {
        slots = new ArrayList<>();
        this.currentHour = 0;
        this.maxStay = maxStay;
        this.earned = 0;
        this.refused = 0;
        for(int i =0; i<bikeslots; i++){
            slots.add(new BikeSlot());
        }
        for(int i =0; i<regular; i++){
            slots.add(new RegularSlot());
        }
        for(int i =0; i<large; i++){
            slots.add(new LargeSlot());
        }

    }

    public ParkingLot(int currentHour, int earned, int refused) {
        this.currentHour = currentHour;
        this.earned = earned;
        this.refused = refused;
    }

    public int getCurrentHour() {
        return currentHour;
    }

    public int getMaxStay() {
        return maxStay;
    }

    public int getEarned() {
        return earned;
    }

    public int getRefused() {
        return refused;
    }
    public void addRefusal(){
        refused++;
    }
    public Slot findFreeSlot(String type){
        for(Slot slot : slots){
            if (!slot.isOccupied() && slot.getSlot().equals(type)) {
                return slot;
            }
        }
        return null;
    }
    public void parkVehicle(Vehicle vehicle) throws NoPlateException, NoSlotException{
        if(vehicle.getPlate() == null){
            throw new NoPlateException("Cant park without a plate");
        }
        Slot tempSlot = null;
        if(vehicle instanceof Bike){
            tempSlot = findFreeSlot("BIKE");
            if(tempSlot == null){
                tempSlot = findFreeSlot("REGULAR");
            }
            if(tempSlot == null){
                tempSlot = findFreeSlot("LARGE");
            }
            if(tempSlot == null){
                throw new NoSlotException("No free space available!!");
            }
        } else if (vehicle instanceof Car) {
                tempSlot = findFreeSlot("REGULAR");
                if(tempSlot == null){
                    tempSlot = findFreeSlot("LARGE");
                }
                if (tempSlot == null){
                    throw new NoSlotException("No free space available!!");
                }
        }
        else if(vehicle instanceof Truck){
            tempSlot = findFreeSlot("LARGE");
            if(tempSlot == null){
                throw new NoSlotException("No free space available!!");
            }

        }
        tempSlot.park(vehicle);

    }
}
