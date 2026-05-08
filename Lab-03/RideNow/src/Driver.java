public class Driver {

    private int id;
    private String name;
    private String licencePlate;
    private boolean x=true;
    public Driver(int id, String name, String licencePlate){
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;

    }
    public Driver(int id, String name, String licencePlate, boolean x){
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;
        this.x=x;
    }

}
