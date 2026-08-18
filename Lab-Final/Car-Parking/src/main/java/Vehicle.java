import java.util.ServiceLoader;

public class Vehicle {
    private final String Vehicleplate;
    private final int hour;
    private final Category category;
    private final slotType keptslot;

    public Vehicle(String vehicleplate, int hour, Category category, slotType keptslot) {
        this.Vehicleplate = vehicleplate;
        this.hour = hour;
        this.category = category;
        this.keptslot = keptslot;
    }

    public String VehiclePlate(){
    return null;
    }

    public int getHour(){
        return 0;
    }

    public slotType getKeptslot() {
        return keptslot;
    }
}
