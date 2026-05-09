public class Driver {
    private int id;
    private String name;
    private String licensePlate;
    private boolean isAvailable;

    public Driver(int id, String name, String licensePlate) {
        this.id = id;
        this.name = name;
        this.licensePlate = licensePlate;
    }

    public Driver(int id, String name, String licensePlate, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.licensePlate = licensePlate;
        this.isAvailable = isAvailable; 
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public String toString(){
        String availableStatus;
        if(isAvailable){
            availableStatus = "[AVAILABLE]";
        }else{
            availableStatus = "[BUSY]";
        }
        return "Driver[" + id + "] " + name + " (" + licensePlate + ") " + availableStatus;
    }
}
