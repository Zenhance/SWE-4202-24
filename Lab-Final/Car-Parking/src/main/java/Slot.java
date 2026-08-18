package main.java;

public abstract class Slot {
    private final double firstHourRate;
    private final double furtherHourRate;
    private final double surchargeRate;
    private Vehicle currentVehicle;
    private boolean isOccupied;

    public Slot(int firstHourRate, int furtherHourRate, int surchargeRate) {
        this.firstHourRate = firstHourRate;
        this.furtherHourRate = furtherHourRate;
        this.surchargeRate = surchargeRate;
        this.isOccupied = false;
        this.currentVehicle = null;
    }

    public double getFirstHourRate() {
        return firstHourRate;
    }

    public double getFurtherHourRate() {
        return furtherHourRate;
    }

    public double getSurchargeRate() {
        return surchargeRate;
    }

    public abstract String getSlot();

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }
    public void park(Vehicle vehicle) {
        this.currentVehicle = vehicle;
        this.isOccupied = true;
    }
    public void remove() {
        this.currentVehicle = null;
        this.isOccupied = false;
    }
    public double calculateBill(double hours){
        if (currentVehicle == null) {
            return 0;
        }
        hours = Math.ceil(hours);
        double bill =0;
        if(hours == 1){
            bill = bill+firstHourRate;

        }
        else {
            bill = firstHourRate+(hours*furtherHourRate);
        }
    return bill+surchargeRate;

    }
}
