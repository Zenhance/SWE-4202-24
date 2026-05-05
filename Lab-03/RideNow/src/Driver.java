public class Driver {

    private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;

    Driver(int id, String name, String licencePlate){
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        isAvailable = true;
    }

    Driver(int id, String name, String licencePlate, boolean isAvailable){
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = isAvailable;
    }

    // getters
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getLicencePlate(){
        return licencePlate;
    }

    public boolean isAvailable(){
        return isAvailable;
    }
    public String toString(){
        String res = "Driver[" + id + "]" + " " + name + " " + "(" + licencePlate + ")" + "[" + (isAvailable? "AVAILABLE":"BUSY") + "]";

        return res;
    }

}
