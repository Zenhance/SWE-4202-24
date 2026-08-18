public class BillingService {

    public int calculate(Vehicle vehicle) {

        return calculate(vehicle, vehicle.getParkedHours());
    }

    public int calculate(Vehicle vehicle, int hours) {
        hours = Math.max(1, hours);

        ParkingSlot slot = vehicle.getParkingSlot();

        if (slot == null) {
            return 0;
        }

        SlotType slotType = slot.getType();

        int bill = slotType.getFirstHourFee();

        if (hours > 1) {
            bill += (hours - 1) * slotType.getFurtherHourFee();
        }

        if (vehicle.needsSurcharge()) {
            bill += slotType.getSurcharge();
        }

        bill = vehicle.getDiscountScheme().apply(bill);
        return Math.max(0, bill);
    }
    public int calculateEvictionBill(Vehicle vehicle, int maxStay) {

        return calculate(vehicle, maxStay + 1);
    }
}