public class Driver {

    private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;

    // Constructor (available by default)
    public Driver(int id, String name, String licencePlate) {
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = true;
    }

    // Full constructor
    public Driver(int id, String name, String licencePlate, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = isAvailable;
    }

    // Getters
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

    // Setter for availability
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // String representation
    public String toString() {
        String status = isAvailable ? "AVAILABLE" : "BUSY";
        return "Driver[" + id + "] " + name + " ("
                + licencePlate + ") [" + status + "]";
    }
}
