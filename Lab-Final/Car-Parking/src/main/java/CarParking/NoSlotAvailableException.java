package CarParking;

public final  class NoSlotAvailableException  extends ParkingException{
    public NoSlotAvailableException(){
        super("No acceptable slot is free");

    }
}
