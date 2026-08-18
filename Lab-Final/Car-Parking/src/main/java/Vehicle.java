public abstract class Vehicle {
    private String plate;
    private String discount;
    private int hours;
    private ParkingSlot slot;

    public Vehicle(String plate,String discount){
        this.plate=plate;
        this.discount=discount;
        this.hours=0;
        this.slot=null;
    }
    public String getPlate(){
        return plate;
    }

public String getDiscount(){
        return discount;
}
public int getHours(){
        return hours;
}

public void addHour(int hours){
        this.hours= this.hours+hours;
}

public ParkingSlot getSlot(){
        return slot;
}

public void setSlot(ParkingSlot slot){
        this.slot=slot;
}

public abstract String getOwnSlotType();
public abstract String[] getAcceptedSlotTypes();
}
