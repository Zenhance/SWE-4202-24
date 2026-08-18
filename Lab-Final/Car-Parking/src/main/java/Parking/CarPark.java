package Parking;

import Slot.Slot;
import Slot.SlotType;

import Vehicle.Vehicle;

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

}
