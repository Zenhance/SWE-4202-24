public class Car extends Vehicle {

    public Car(String plate, String discount) {
        super(plate, Integer.parseInt(discount));
    }
    public ParkingSlot[] slot(){
        return new ParkingSlot[]{
                ParkingSlot.REGULAR,
                ParkingSlot.LARGE
            };
        }
    public String getKind() {
        return "CAR";
         }
    }



