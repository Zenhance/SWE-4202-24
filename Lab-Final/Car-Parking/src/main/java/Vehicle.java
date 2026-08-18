import java.util.ServiceLoader;

public class Vehicle {
    private final String Vehicleplate;
    private int time;
    private final Category category;
    private slotType keptslot;

    public Vehicle(String vehicleplate, int time, Category category, slotType keptslot) {
        this.Vehicleplate = vehicleplate;
        this.time = time;
        this.category = category;
        this.keptslot = keptslot;
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
    public abstract slotType[] slotpreference();
    public abstract int hourlyRate();
}

