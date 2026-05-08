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
}