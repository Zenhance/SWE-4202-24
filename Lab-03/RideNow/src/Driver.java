public class Driver {
    private int id;
    private String name;
    private String LicensePlate;
    private boolean isAvailable;

    public Driver(int id, String name, String LicensePlate,boolean isAvailable){
        this.id=id;
        this.name=name;
        this.LicensePlate=LicensePlate;
        this.isAvailable=isAvailable;
    }
    public Driver(int id, String name, String LicensePlate){
        this.id=id;
        this.name=name;
        this.LicensePlate=LicensePlate;
        this.isAvailable=true ;
    }


    public int getId(){

        return id;
    }
    public String getName(){

        return name;
    }

    public boolean isAvailable(){

        return isAvailable;
    }
    public void setAvailable(boolean isAvailable){
        this.isAvailable=isAvailable;
    }

    public String toString(){
        return String.format("Driver[%d] %s (%s) [%s]", id, name ,LicensePlate ,isAvailable ? "Available" : "Busy");
    }

    public String getLicencePlate() {
        return LicensePlate;
    }
}
