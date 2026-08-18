public abstract class Vehicle  {
    VehicleType vehicleType;
    private final String plate;
    public  int hours;
    Discount discount;
    slotsType slot;
    public Vehicle(String plate, Discount discount, int hours, slotsType slot){
        this.plate=plate;
        this.discount=discount;
        this.hours=hours;
        this.slot=slot;
    }

   public abstract slotsType[] slots();
    public abstract int hourlyRate();
}
