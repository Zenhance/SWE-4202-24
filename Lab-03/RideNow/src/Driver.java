public class Driver {
    private int id;
    private String name;
    private String licensePlate;
    private boolean isAvailable;

    public Driver(int id, String name, String licensePlate){
        this.id=id;
        this.name=name;
        this.licensePlate=licensePlate;
        this.isAvailable=isAvailable;
    }

    public Driver(int id, String name, String licensePlate){
        this(id,name,licensePlate,true);s
    }
}
