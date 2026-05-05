public class Driver {
    private int id;
    private String name;
    private String licencePlate;
    boolean isAvailable;

    Driver(int id, String name, String licencePlate) {
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;
    }

    Driver(int id, String name, String licencePlate, boolean isAvailable) {
        this.id=id;
        this.name=name;
        this.licenceplate=licencePlate;
        this.isAvailable=isAvailable;
    }


}
