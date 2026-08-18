package model;

import exceptions.InvalidLicensePlateException;

public abstract class Vehicle {
    private final String type;
    private final String licencePlate;
    private final String permit;
    private boolean isParked;
    private int parkedTime;

    public Vehicle(String type, String licencePlate, String permit) {
        if(type==null || permit==null){
            throw new IllegalArgumentException();
        }
        if(licencePlate==null){
            throw new InvalidLicensePlateException("licencePlate is null");
        }

        this.type = type;
        this.licencePlate = licencePlate;
        this.permit = permit;
        this.parkedTime = 0;
        isParked = false;
    }

    public String getType() {
        return type;
    }
    public String getLicencePlate() {
        return licencePlate;
    }
    public String getPermit() {
        return permit;
    }
    public int getParkedTime() {
        return parkedTime;
    }

    public void park(){
        isParked = true;
        parkedTime++;
    }
}
