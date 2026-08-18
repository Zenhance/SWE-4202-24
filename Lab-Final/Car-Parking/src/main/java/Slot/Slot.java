package Slot;

import Vehicle.Vehicle;

public class Slot {
    private SlotType type;
    private Vehicle vehicle;

    public Slot(SlotType type){
        if(type==null){
            throw new IllegalArgumentException("Invalid Slot type");
        }
        this.type=type;
        this.vehicle=null;
    }

    public SlotType getType(){
        return type;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public boolean isFree(){
        return vehicle==null;
    }

    public void park(Vehicle vehicle) {
        if(vehicle==null){
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
        this.vehicle=vehicle;
    }

    public Vehicle removeVehicle(){
        Vehicle removed=vehicle;
        vehicle=null;
        return removed;
    }




}
