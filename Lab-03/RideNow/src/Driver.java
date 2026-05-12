public class Driver {

<<<<<<< HEAD
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

=======
    private final int    id;
    private final String name;
    private final String licencePlate;
    private boolean      isAvailable;

    /** Full constructor: set all four fields explicitly. */
    public Driver(int id, String name, String licencePlate, boolean isAvailable) {
        this.id           = id;
        this.name         = name;
        this.licencePlate = licencePlate;
        this.isAvailable  = isAvailable;
    }

    /** Convenience constructor: newly registered drivers are available by default. */
    public Driver(int id, String name, String licencePlate) {
        this(id, name, licencePlate, true);   // delegate to full constructor
    }

    public int     getId()           { return id; }
    public String  getName()         { return name; }
    public String  getLicencePlate() { return licencePlate; }
    public boolean isAvailable()     { return isAvailable; }

    /** Mark this driver as available or busy. */
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        String status = isAvailable ? "AVAILABLE" : "BUSY";
        return String.format("Driver[%d] %s (%s) [%s]", id, name, licencePlate, status);
>>>>>>> master
    }
}