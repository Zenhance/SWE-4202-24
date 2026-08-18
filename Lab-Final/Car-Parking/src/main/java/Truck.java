public class Truck extends Vehicle {


    public Truck(String plate, int discount) {
        super(plate, discount);
    }
    public ParkingSlot[] slot(){
        return new ParkingSlot[]{
                ParkingSlot.LARGE
        };
    }

    @Override
    public String getKind() {
        return "Truck";
    }




}
