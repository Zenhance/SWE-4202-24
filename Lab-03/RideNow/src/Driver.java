public class Driver {

    private String name;
    private int id;
    private String licencePlate;
    private boolean isAvailable;


    //newly registered driver
    public Driver(int id, String name, String licencePlate){

        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;

    }

    //full time driver
    public Driver(int id, String name, String licencePlate, boolean isAvailable){

        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = isAvailable;

    }

    //getters
    public static int getId(){
        return id;
    }

    public static String getName() {
        return name;
    }

    public static String getLicencePlate() {
        return licencePlate;

    }

    public static boolean isAvailable() {
        return isAvailable;
    }

    //availability


    public static void setAvailable(boolean available) {
        isAvailable = available;
    }


    public static String toString(int id, String name, boolean isAvailable, String licencePlate){
        String str = "Driver [" + id + "]" + name + " (" licencePlate + ") " +  (isAvailable)? "[AVAILABLE]" : "[BUSY]";

        return str;

    }
}