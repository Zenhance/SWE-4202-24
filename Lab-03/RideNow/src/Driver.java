public class Driver {
    private int id;
    private String name;
    private String licensePlate;
    private boolean setAvailable;

    public Driver(int id, String name, String licensePlate){
        this.id=id;
        this.name=name;
        this.licensePlate=licensePlate;
        this.setAvailable=setAvailable;
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
    public boolean setAvailable(boolean isavailable){
        return setAvailable;
    }

    public String toString(){
        return String.format("Driver[%d] %s (%s) [%s]", id, name ,licensePlate ,setAvailable ? "Available" : "Busy");
    }
}
