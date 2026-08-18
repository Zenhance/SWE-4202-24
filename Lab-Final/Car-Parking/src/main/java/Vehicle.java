import java.util.ServiceLoader;

public class Vehicle {
    private final String Vehicleplate;
    private final int hourEntered;
    private final Category category;
    private final slotType keptslot;

    public Vehicle(String vehicleplate, int hourEntered, Category category, slotType keptslot) {
        this.Vehicleplate = vehicleplate;
        this.hourEntered = hourEntered;
        this.category = category;
        this.keptslot = keptslot;
    }

    public String VehiclePlate(){
    return null;
    }

    public int getHourEntered(){
        return 0;
    }

    public slotType getKeptslot() {
        return keptslot;
    }
}
