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


    public int getId(){
        return id;
    }
    public String getname(){
        return name;
    }
    public String getLicensePlate(){
        return licensePlate;
    }
    public boolean isAvailable(boolean isavailable){
        return isavailable;
    }

    public String toString(){
        return String.format("Driver[%d] %s (%s) [%s]", id, name ,licensePlate ,isAvailable ? "Available" : "Busy");
    }
}
