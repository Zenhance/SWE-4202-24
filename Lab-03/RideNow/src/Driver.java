public class Driver {
    private int id;
    private String name;
    private String licensePlate;
    private boolean isAvailable;

    public Driver(int id, String name, String licencePlate){
        this.isAvailable = true;
        this.id = id;
        this.name = name;
        this.licensePlate = licencePlate;
    }

    public Driver(int id, String name, String licencePlate, boolean isAvailable){
        this.isAvailable = isAvailable;
        this.id = id;
        this.name = name;
        this.licensePlate = licencePlate;

    }


}
