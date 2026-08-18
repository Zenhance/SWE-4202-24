public class Car extends Vehicle {

    public Car(String plate, int discount) {
        super(plate, discount);
    }
        public ParkingSlot[] acceptedSlots() {
            return new ParkingSlot[] {
                    ParkingSlot.REGULAR,
                    ParkingSlot.LARGE
            };
        }
    public String getKind() {
        return "CAR";
    }
    }



