import java.util.ServiceLoader;

public abstract class Vehicle {
    private final String Vehicleplate;
    private int time;
    private final Category category;
    private discountScheme scheme;
    private slotType keptslot;

    public Vehicle(String Vehicleplate, Category category) {
        this.Vehicleplate = Vehicleplate;

        this.category = category;

    }

    public String getVehiclePlate(){
    return Vehicleplate;
    }

    public int getTime(){
        return time;
    }

    public slotType getKeptslot() {
        return keptslot;
    }

    public Category getCategory(){
        return category;
    }

    public void park(slotType keptslot,int time){
        this.keptslot=keptslot;
        this.time=time;
    }
    public int stayHours(int presentTime)
    {
        return presentTime-time;
    }

    public discountScheme getScheme()
    {
        return scheme;
    }

    public abstract slotType[] prefferedSlot();
    public abstract int hourlyRate();
}

