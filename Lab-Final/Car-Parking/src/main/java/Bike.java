public class Bike extends Vehicle {


    protected Bike(String plate, String discount) {
        super(plate, Integer.parseInt(discount));
    }
    public ParkingSlot[] slot(){
        return new ParkingSlot[]{
                ParkingSlot.Bike,
                ParkingSlot.REGULAR,
                ParkingSlot.LARGE
        };
    }
    public String getKind(){
        return "Bike";
    }
}
