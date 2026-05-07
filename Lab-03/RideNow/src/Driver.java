public class Driver {
    int id;
    String name;
    String licencePlate;
    boolean isAvailable;
    Driver(int id, String name, String licencePlate){
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;
        this.isAvailable=true;
    }
    Driver(int id, String name, String licencePlate, boolean isAvailable){
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;
        this.isAvailable=isAvailable;
    }
}
