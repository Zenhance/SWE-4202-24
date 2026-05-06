public class Driver {
    private int id;
    private String name;
    private String licensePlate;
    private boolean isAvailable;

    Driver(int id,String name,String licencePlate){
        this.id=id;
        this.licensePlate=licencePlate;
        this.name=name;
    }
    Driver(int id,String name,String licencePlate,boolean isAvailable){
        this.id=id;
        this.licensePlate=licencePlate;
        this.name=name;
        this.isAvailable=isAvailable;
    }



}
