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
    int getId(){
        return id;
    }
    String getName(){
        return name;
    }
    String getLicencePlate(){
        return licencePlate;
    }
    boolean isAvailable(){
        return isAvailable;
    }
    void setAvailable(boolean available){
        this.isAvailable=available;
    }
    public  String toString(){
        return String.format("Driver[%d] %s (%s) [%b]", id,name,licencePlate,isAvailable);
    }

}
