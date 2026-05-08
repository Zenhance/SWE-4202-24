public class Driver {

    private String name;
    private int id;
    private String licencePlate;
    private boolean isAvailable;


    //newly registered driver
    public Driver(int id, String name, String licencePlate){

    }

    //full time driver
    public Driver(int id, String name, String licencePlate, boolean isAvailable){

    }

    //getters
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLicencePlate() {
        return licencePlate;

    }

    public boolean isAvailable() {
        return isAvailable;
    }

    //availability


    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    public String toString(int id, String name, boolean isAvailable, String licencePlate){
        String str = "Driver [" + id + "]" + name + " (" licencePlate + ") " +  (isAvailable)? "[AVAILABLE]" : "[BUSY]";

        return str;

    }
}