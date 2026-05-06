public class Driver {
    private final int id;
    private final String name;
    private final String licencePlate;
    private boolean isAvailable=true;

    Driver(int id, String name, String licencePlate) {
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
    }

    Driver(int id, String name, String licencePlate, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable=isAvailable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getLicencePlate(){
    return licencePlate;
    }
    public boolean isAvailable(){
        return isAvailable;
    }

    void setAvailable(boolean available){
        this.isAvailable=available;
    }
    public String toString(){
        String status=isAvailable?"AVAILABLE":"BUSY";
        return String.format("Driver[%d] %s (%s) [%s]",id,name,licencePlate,status);
    }

}