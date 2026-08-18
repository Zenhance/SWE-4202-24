public final class CarPark {
    private int refused;

    public CarPark(
            int bikeSlots,
            int regularSlots,
            int largeSlots
    ) {
    }

    public void setMaximumStay(int maximumStay) {
    }

    public void admit(Vehicle vehicle)
            throws ParkingException {
    }

    public void passTime(int hours) {
    }

    public void leave(String plate)
            throws VehicleNotFoundException {
    }

    public int bill(String plate)
            throws VehicleNotFoundException {

        return 0;
    }

    public SlotKind slotOf(String plate)
            throws VehicleNotFoundException {

        return null;
    }

    public int freeSlots(SlotKind kind) {
        return 0;
    }

    public int vehicleCount() {
        return 0;
    }

    public int earned() {
        return 0;
    }

    public int refused() {
        return refused;
    }

    public void recordRefusal() {
        refused++;
    }
}