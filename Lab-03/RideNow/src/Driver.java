public class Driver {
    private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;
    Driver(int id, String name, String licencePlate){
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;
        isAvailable=true;
    }
    Driver(int id, String name, String licencePlate, boolean isAvailable){
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;
        this.isAvailable=isAvailable;
    }
    int getId(){return id;}
    String getName(){return name;}
    String getLicencePlate(){return licencePlate;}
    boolean isAvailable(){return isAvailable;}
    public String toString(){
        if (isAvailable()) {return String.format("Driver[%d] %s (%s) [AVAILABLE]",id,name,licencePlate);}
        else {return String.format("Driver[%d] %s (%s) [BUSY]",id,name,licencePlate);}
    }

    public void setAvailable(boolean b) {
        this.isAvailable=b;
    }

}
