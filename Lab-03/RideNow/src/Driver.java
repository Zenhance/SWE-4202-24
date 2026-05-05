public class Driver {

   private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;
    Driver(int id, String name,String licencePlate){
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;
    }
    Driver(int id, String name,String licencePlate,boolean isAvailable){
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
    public String getlicencePlate(){
        return licencePlate;
    }

    public boolean isAvailable(){
        return isAvailable;
    }
    public String toString(int id,String name,String licencePlate, boolean isAvailable){
        String status= isAvailable? "AVAILABLE":"BUSY";
        return String.format("Passenger[%d] %s (%s)[%s]", id,name,licencePlate,isAvailable);
    }

}