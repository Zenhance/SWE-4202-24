//Part C
public class Driver {
    private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;

    public Driver(int id, String name, String licencePlate){
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = true;
    }

    public Driver(int id, String name, String licencePlate, boolean isAvailable){
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getLicencePlate(){
        return licencePlate;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    void setAvailable(boolean available){
        this.isAvailable=available;
    }

    //"Driver[7] Bob (DHA-1234) [AVAILABLE]" or "[BUSY]".
    public String toString(){
        String availability;
        if(isAvailable) {
            availability = new String("AVAILABLE");
        }
        else{
            availability = new String("BUSY");
        }
        return String.format("Driver[%d] %s (%s) [%s]",id,name,licencePlate,availability);
    }
}
