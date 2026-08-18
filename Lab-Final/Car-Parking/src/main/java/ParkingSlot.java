public class ParkingSlot {
    private final String type;
    private Vehicle vehicle;

     public ParkingSlot(String type, Vehicle vehicle) {
         this.type = type;
     }
     public String getType() {
         return type;
     }
     public Vehicle getVehicle() {
         return vehicle;
     }

}
