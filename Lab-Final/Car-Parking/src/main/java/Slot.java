package main.java;

public abstract class Slot {
    private final int firstHourRate;
    private final int furtherHourRate;
    private final int surchargeRate;
    private Vehicle currentVehicle;

    public Slot(int firstHourRate, int furtherHourRate, int surchargeRate) {
        this.firstHourRate = firstHourRate;
        this.furtherHourRate = furtherHourRate;
        this.surchargeRate = surchargeRate;
    }
    public abstract String getSlot();

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }
    public Vehicle (Vehicle type){
        return this.ty
    }
    public double feeCalc(){
        if()

    }
}
