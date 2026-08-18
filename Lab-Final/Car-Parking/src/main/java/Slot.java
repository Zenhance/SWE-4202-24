public abstract class Slot {
    private Vehicle currentVehicle = null;
    public abstract String getKindName();
    public abstract int getFirstHourRate();
    public abstract int getFurtherHourRate();
    public abstract int getSurcharge();

    public boolean isFree() {
        return currentVehicle == null;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public void park(Vehicle vehicle) {
        this.currentVehicle = vehicle;
    }

    public void vacate() {
        this.currentVehicle = null;
    }

    public int calculateBill(int hours, VehicleType vehicleType, Discount discount) {
        int effectiveHours = (hours == 0) ? 1 : hours;
        int baseFee = getFirstHourRate() + (effectiveHours - 1) * getFurtherHourRate();
        return baseFee;



    }






}
