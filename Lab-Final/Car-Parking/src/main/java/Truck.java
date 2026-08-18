import java.util.List;

public class Truck extends Vehicle {

    public Truck(String plate, DiscountScheme discountScheme) {
        super(plate, discountScheme);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.TRUCK;
    }

    @Override
    public List<SlotType> getPreferredSlotTypes() {
        return List.of(SlotType.LARGE);
    }
}