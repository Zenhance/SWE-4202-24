

public class Truck extends Vehicle {

    public Truck(String registration, String permit) {
        super(registration, permit);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }

    @Override
    public boolean canPark(SlotType slotType) {
        return slotType == SlotType.LARGE;
    }
}
