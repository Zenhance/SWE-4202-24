package model;

public class Slot {
    private String type;
    private Vehicle vehicle;
    private int firstHourCHarge;
    private int extraHourCHarge;
    private int surcharge;

    public Slot(String type) {
        if(!type.equals("BIKE") && !type.equals("REGULAR") && !type.equals("LARGE")){
            throw new IllegalArgumentException();
        }
        this.type = type;
        if(type.equals("BIKE")){
            firstHourCHarge = 10;
            extraHourCHarge = 5;
            surcharge = 0;
        }
        else if(type.equals("REGULAR")){
            firstHourCHarge = 10;
            extraHourCHarge = 5;
            surcharge = 0;
        }
        else {
            firstHourCHarge = 10;
            extraHourCHarge = 5;
            surcharge = 0;
        }
    }

    public int getFirstHourCHarge() {
        return firstHourCHarge;
    }
    public int getExtraHourCHarge() {
        return extraHourCHarge;
    }
    public int getSurcharge() {
        return surcharge;
    }

    public String getType() {
        return type;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public boolean free() {
        return vehicle == null;
    }

    public void park(Vehicle v) {
        vehicle = v;
    }

    public void remove() {
        vehicle = null;
    }
}
