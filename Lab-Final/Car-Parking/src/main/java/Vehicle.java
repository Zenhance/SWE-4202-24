import java.util.List;

public abstract class Vehicle {
    private final String plate;
    private ParkingSlot parkingSlot;
    private final DiscountScheme discountScheme;
    private int parkedHours;

    protected Vehicle(String plate,DiscountScheme discountScheme) {
        this.plate=plate;
        this.discountScheme = discountScheme;
        this.parkedHours = 0;
    }


    public abstract VehicleType getVehicleType();

    public abstract List<SlotType> getPreferredSlotTypes();



    public String getPlate() {
        return plate;
    }
    public DiscountScheme getDiscountScheme() {
        return discountScheme;
    }
    public int getParkedHours() {
        return parkedHours;
    }
    public void addHour() {
        parkedHours++;
    }
    public void addHours(int hours) {
        parkedHours +=hours;
    }
    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }
    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot= parkingSlot;
    }
    public void removeFromSlot() {
        this.parkingSlot =null;
    }
    public SlotType getNaturalSlotType() {
        return getPreferredSlotTypes().get(0);
    }
    public boolean needsSurcharge() {
        if (parkingSlot==null) {
            return false;
        }
        return parkingSlot.getType()!=getNaturalSlotType();
    }
}