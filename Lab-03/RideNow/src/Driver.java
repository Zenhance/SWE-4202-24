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
        this.id = id;;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = isAvailable;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String  getLicencePlate(){
        return licencePlate;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String toString() {
        String available = String.format("Driver[%d] %s (%s) [AVAILABLE]", id, name, licencePlate);
        String busy = String.format("Driver[%d] %s (%s) [BUSY]", id, name, licencePlate);

        if(isAvailable) return available;
        else return busy;
    }

}