class Slot {
    private final SlotType type;
    private final int firstHourRate;
    private final int furtherHourRate;
    private final int surchargeRate;
    private Vehicle currentVehicle;

    public Slot(SlotType type, int firstHourRate, int furtherHourRate, int surchargeRate) {
        this.type = type;
        this.firstHourRate = firstHourRate;
        this.furtherHourRate = furtherHourRate;
        this.surchargeRate = surchargeRate;
        this.currentVehicle = null;
    }

    public SlotType getType() { return type; }
    public boolean isFree() { return currentVehicle == null; }
    public Vehicle getCurrentVehicle() { return currentVehicle; }

    public void park(Vehicle vehicle) {
        this.currentVehicle = vehicle;
    }

    public void clear() {

        this.currentVehicle = null;
    }

    public int calculateBill(int hours, VehicleType vehicleBelongsTo, SchemeType scheme) {
        if (hours == 0) return 0;

        int bill = firstHourRate;
        if (hours > 1) {
            bill += (hours - 1) * furtherHourRate;
        }

        if (!doesVehicleBelongHere(vehicleBelongsTo)) {
            bill += surchargeRate;
        }

        switch (scheme) {
            case STUDENT:
                bill = bill - (bill * 20 / 100);
                break;
            case WEEKEND:
                bill = bill - 10;
                if (bill < 0) bill = 0;
                break;
            case NONE:
            default:
                break;
        }
        return bill;
    }

    public int getFurtherHourRate() {
        return furtherHourRate;
    }

    private boolean doesVehicleBelongHere(VehicleType vType) {
        if (this.type == SlotType.BIKE && vType == VehicleType.BIKE) return true;
        if (this.type == SlotType.REGULAR && vType == VehicleType.CAR) return true;
        if (this.type == SlotType.LARGE && vType == VehicleType.TRUCK) return true;
        return false;
    }
}