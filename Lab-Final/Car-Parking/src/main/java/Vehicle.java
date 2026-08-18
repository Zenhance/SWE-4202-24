public abstract class Vehicle {
    VehicleType vehicleType;
    private final String plate;
    private int hours;
    Discount discount;
    slotsType slot;
    public Vehicle(String plate, Discount discount, int hours, slotsType slot){
        this.plate=plate;
        this.discount=discount;
        this.hours=0;
        this.slot=slot;
    }

   public abstract slotsType[] slots();
    public abstract int hourlyRate();
}
