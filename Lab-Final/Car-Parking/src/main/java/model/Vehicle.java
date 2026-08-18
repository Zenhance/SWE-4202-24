package model;

import exceptions.InvalidLicensePlateException;

public abstract class Vehicle {
    private final String licencePlate;
    private final String permit;
    private int entryTime;


    public Vehicle(String licencePlate, String permit) {
        if(!permit.equals("NONE") && !permit.equals("STUDENT") && !permit.equals("WEEKEND")){
            throw new IllegalArgumentException();
        }
        if(licencePlate==null){
            throw new InvalidLicensePlateException();
        }

        this.licencePlate = licencePlate;
        this.permit = permit;
    }

    public String getLicencePlate() {
        return licencePlate;
    }
    public String getPermit() {
        return permit;
    }
    public void setEntryTime(int currentTime){
        entryTime = currentTime;
    }
    public int getEntryTime(){
        return entryTime;
    }

    public abstract String[] slotOrder();
    public abstract String bestSlot();
}
