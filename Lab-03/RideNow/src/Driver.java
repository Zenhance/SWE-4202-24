public class Driver {
    private String id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;

    public Driver(String id, String name, String licencePlate) {
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = true;
    }

    public Driver(String id, String name, String licencePlate, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = isAvailable;
    }


}
