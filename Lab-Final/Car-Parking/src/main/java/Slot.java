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

    public static void setMaxStay(int hours) {
    }








}
