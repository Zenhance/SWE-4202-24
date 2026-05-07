public class Driver {
    private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;


    Driver(int id,String name,String licencePlate){
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;
        this.isAvailable=true;
    }
    Driver(int id,String name,String licencePlate,boolean isAvailable){
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;
        this.isAvailable=isAvailable;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getLicencePlate(){
        return licencePlate;
    }
    public void setAvailable(boolean available){
        this.isAvailable=available;
    }
    public String toString(){
        String status;
        if(isAvailable){
            status="AVAILABLE";

        }
        else{
            status="BUSY";
        }
        return "Driver["+this.id+"] "+this.name+" ("+this.licencePlate+") ["+status+"]";
    }
}
