public class Calculatebill {

    public int calculate(Vehicle vehicle,int hours) {

        if (hours < 1) {
            hours = 1;
        }

        Slot slot = vehicle.getSlot();

        int bill =
                slot.firstHourRate() + (hours - 1) * slot.additionalHoursRate();

        if (needsSurcharge(vehicle, slot)) {
            bill += slot.surchargeRate();
        }

        bill = applyDiscount(
                bill,
                vehicle.getScheme()
        );

        return Math.max(0, bill);
    }

    private boolean needsSurcharge(Vehicle vehicle, Slot slot) {

        if (vehicle.getType() == Vehicle.Type.BIKE) {
            return slot.getType() != Slot.Type.BIKE;
        }

        if (vehicle.getType() == Vehicle.Type.CAR) {
            return slot.getType() != Slot.Type.REGULAR;
        }

        return slot.getType() != Slot.Type.LARGE;
    }

    private int applyDiscount(
            int bill,
            Vehicle.Scheme scheme
    ) {

        if (scheme == Vehicle.Scheme.NONE) {
            return bill;
        }

        if (scheme == Vehicle.Scheme.STUDENT) {
            return bill - bill * 20 / 100;
        }
        return Math.max(0, bill - 10);
    }
}
