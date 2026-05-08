public class Driver {

   private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;
    public Driver(int id, String name,String licencePlate){
        this(id,name,licencePlate,true);
    }
    public Driver(int id, String name,String licencePlate,boolean isAvailable){
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

    public boolean isAvailable(boolean isAvailable){
        return isAvailable;
    }
    public String toString(){
        String status= isAvailable? "AVAILABLE":"BUSY";
        return String.format("Passenger[%d] %s (%s)[%s]", id,name,licencePlate,isAvailable);
    }

}