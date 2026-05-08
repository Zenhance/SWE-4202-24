public class Driver {
    private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;

    public Driver(int id, String name, String licencePlate){
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;
        this.isavailable=true;
    }
    public Driver(int id, String name, String licencePlate,boolean isavailable){
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;
        this.isavailable=isavailable;
    }
}
