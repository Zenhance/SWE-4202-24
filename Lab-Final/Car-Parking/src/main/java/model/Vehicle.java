package model;

import exceptions.InvalidLicensePlateException;

public abstract class Vehicle {
    private final String kind;
    private final String licencePlate;
    private final String permit;
    private boolean isParked;
    private int parkedTime;

    public Vehicle(String kind, String licencePlate, String permit) {
        if(kind==null || permit==null){
            throw new IllegalArgumentException();
        }
        if(licencePlate==null){
            throw new InvalidLicensePlateException("licencePlate is null");
        }

        this.kind = kind;
        this.licencePlate = licencePlate;
        this.permit = permit;
        this.parkedTime = 0;
        isParked = false;
    }

    public String getKind() {
        return kind;
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
