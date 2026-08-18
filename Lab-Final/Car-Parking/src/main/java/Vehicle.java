public abstract class Vehicle {
    VehicleType vehicleType;
    private final String plate;
    private int hours;
    Discount discount;
    slots slot;
    public Vehicle(String plate,Discount discount,int hours,slots slot){
        this.plate=plate;
        this.discount=discount;
        this.hours=hours;
        this.slot=slot;
    }


}
