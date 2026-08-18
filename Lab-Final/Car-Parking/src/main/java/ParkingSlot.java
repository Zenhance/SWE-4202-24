public class ParkingSlot {
    private final String type;
    private Vehicle vehicle;

     public ParkingSlot(String type, Vehicle vehicle) {
         this.type = type;
     }
     public ParkingSlot(String type){
         this.type = type;
     }
     public String getType() {
         return type;
     }
     public Vehicle getVehicle() {
         return vehicle;
     }
     public boolean isFree() {
         return vehicle == null;
     }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        vehicle.setSlot(this);
    }
    public void free(){
         this.vehicle = null;
    }

}
