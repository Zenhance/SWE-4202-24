public abstract class Vehicle {
    private String plate;
    private String discount;
    private int hours;
    private ParkingSlot slot;

    public Vehicle(String plate,String discount){
        this.plate=plate;
        this.discount=discount;
        this.hours=0;
        this.slot=null;
    }
    public String getPlate(){
        return plate;
    }


}
