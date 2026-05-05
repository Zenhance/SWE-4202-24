public class Driver {
    private int id;
    private String name;
    private String licencePlate,
    boolean isAvailable = true;

    Driver(int id, String name, String licencePlate, boolean isAvailable){
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = isAvailable;
    }
    Driver(int id, String name, String licencePlate){
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getLicencePlate(){
        return this.licencePlate;
    }
}
