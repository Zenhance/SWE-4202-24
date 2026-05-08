public class Driver {

    private int id;
    private String name;
    private String licencePlate;
    private boolean x=true;
    public Driver(int id, String name, String licencePlate){
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;

    }
    public Driver(int id, String name, String licencePlate, boolean x){
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;
        this.x=x;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public boolean isAvailable(){
        return x;
    }
    public void setAvailable(boolean x){
        this.x=x;
    }
    public String toString(){
        if(x)
            return String.format("Driver[%d] %s (%s) [AVAILABLE]",id,name,licencePlate);
        else
            return String.format("Driver[%d] %s (%s) [BUSY]",id,name,licencePlate);
    }

}
