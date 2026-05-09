public class Driver {

    private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;

    Driver(int id, String name, String licencePlate){
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = true;
    }

    Driver(int id, String name, String licencePlate, boolean isAvailable){
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = isAvailable;
    }

    // getters
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getLicencePlate(){
        return licencePlate;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void setAvailable(boolean available){
        this.isAvailable = available;
    }

    @Override
    public String toString(){

        return String.format("Driver[%d] %s (%s) [%s]", id, name, licencePlate, isAvailable? "Available": "Busy");
    }

}
