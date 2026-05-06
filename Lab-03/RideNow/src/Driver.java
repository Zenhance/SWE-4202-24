public class Driver {
    private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable=true;

    Driver(int id, String name, String licencePlate) {
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
    }

    Driver(int id, String name, String licencePlate, boolean isAvailble) {
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getLicencePlate(){
    return licencePlate;
    }
    public boolean isAvailable(){
        return isAvailable;
    }

    void setAvailable(boolean available){
        this.isAvailable=available;
    }
    public String toString(){
        return "Driver"+"["+id+"]"+" "+name+ " "+licencePlate+" "+isAvailable;
    }

}