public class Slot {
    public enum Type {
        BIKE,CAR,TRUCK
    }
    private Type type;
    private Vehicle vehicle;

    public Slot(Type type){
        this.type = type;
    }
    public Type getType(){
        return type;
    }
    public boolean isFree(){
        return vehicle == null;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }

    public void occupy(Vehicle vehicle){
        this.vehicle = vehicle;
        vehicle.setSlot(this);
    }




}
