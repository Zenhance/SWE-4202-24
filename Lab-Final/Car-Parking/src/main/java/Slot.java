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

    public void free(){
        if(vehicle != null){
            vehicle.setSlot(null);
        }
        vehicle = null;
    }
    public Catagory catagory;
    public int firstHourRate(){
        return switch(catagory){
            case BIKE -> 10;
            case REGULAR -> 30;
            case LARGE -> 50;
        };
    }

    public int surchargeRate(){
        return switch(catagory){
            case BIKE -> 0;
            case REGULAR -> 15;
            case LARGE -> 25;
        };
    }

    public int additionalHoursRate(){
        return switch(catagory){
            case BIKE -> 5;
            case REGULAR -> 20;
            case LARGE -> 40;
        };

    }


}
