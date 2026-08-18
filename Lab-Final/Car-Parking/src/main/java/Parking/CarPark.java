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

    public void parkVehicle(Vehicle vehicle) throws NoPlateException, NoSlotException {
        if(vehicle==null || vehicle.getNumberPlate()==null || vehicle.getNumberPlate().isBlank()){
            throw new Exception.NoPlateException("Vehicle has no plate");
        }

        Slot slot= findAvailableSlot(vehicle);
        if(slot==null){
            throw new NoSlotException("No suitable slot found");
        }
        vehicle.setEntryTime(currentTime);

        slot.park(vehicle);
        vehicle.add(vehicles);

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
        if(discountScheme==DiscountScheme.NONE){
            return bill;
        }

        if(discountScheme== Slot.DiscountScheme.STUDENT){
            return bill-(bill*20/100);
        }
        if(discountScheme== Slot.DiscountScheme.WEEKEND){
            return Math.max(0, bill-10);
        }

        return bill;
    }

}
