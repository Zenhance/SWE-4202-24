public class Bike extends Vehicle {


    protected Bike(String plate, int discount) {
        super(plate, discount);
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
