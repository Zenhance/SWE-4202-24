import java.util.ArrayList;

public class Car extends Vehicle {

    public Car(String plate, int discount) {
        super(plate, discount);
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



