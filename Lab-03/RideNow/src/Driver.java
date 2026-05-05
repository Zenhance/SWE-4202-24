public class Driver {
    private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;
    Driver(int id, String name, String licencePlate){
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;
        isAvailable=true;
    }
    Driver(int id, String name, String licencePlate, boolean isAvailable){
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;
        this.isAvailable=isAvailable;
    }
    void getId(){return id;}
    void getName(){return name;}
    void getLicencePlate(){return licencePlate;}
    void isAvailable(){return isAvailable;}
    void setAvailable(boolean available){
        isAvailable=available;
    }

}
