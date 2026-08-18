package Parking;

import Slot.Slot;
import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;

public class CarPark {
    private ArrayList<Slot> slots;
    private HashMap<String, Vehicle> vehicles;

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

        this.currentTime=0;
        this.earned=0;
        this.refused=0;

    }
}
