public class Driver {

    private int id;
    private String name;
    private String licensePlate;
    private boolean isAvailable;


    public Driver(int id, String name, String LicensePlate, boolean isAvailable){
        this.id=id;
        this.name=name;
        this.licensePlate = licensePlate;
        this.isAvailable=isAvailable;

    }

    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }

    public String getLicencePlate() {
        return licensePlate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public String toString() {
        String status = isAvailable ? "AVAILABLE" : "BUSY";
        return String.format("Driver[%d] %s (%s) [%s]", id, name, licensePlate, status);
    }
}
