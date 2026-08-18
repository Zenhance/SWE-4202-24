public class Truck extends Vehicle {


    public Truck(String plate, String discount) {
        super(plate, Integer.parseInt(discount));
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
