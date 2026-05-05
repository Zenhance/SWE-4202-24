//Part C
public class Driver {
    private final int id;
    private final String name;
    private final String licencePlate;
    private boolean isAvailable;
    
    public Driver(int id, String name, String licencePlate) {
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = true;
    }
    
    public Driver(int id, String name, String licencePlate, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = isAvailable;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getLicencePlate() {
        return licencePlate;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    
    //"Driver[7] Bob (DHA-1234) [AVAILABLE]" or "[BUSY]".
    public String toString() {
        return String.format("Driver[%d] %s (%s) [%s]", id, name, licencePlate, isAvailable ? "AVAILABLE" : "BUSY");
    }
}
