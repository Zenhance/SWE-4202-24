public class Driver {

    private int id;
    private String name;
    private String licensePlate;
    private boolean isAvailable;

    public Driver(int id, String name, String licensePlate, boolean isAvailable){
        this.id = id;
        this.name = name;
        this.licensePlate = licensePlate;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLicencePlate() {
        return licensePlate;
    }

    public void setAvailable(boolean newBoolean){
        this.isAvailable = newBoolean;
    }


}