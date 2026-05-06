public class Driver {
    private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;

    //available constructor
    public Driver(int id,String name,String licencePlate) {
        this(id, name, licencePlate, true);
    }

    public Driver(int id,String name,String licencePlate,boolean isAvailable){
        this.id=id;
        this.name=name;
        this.licencePlate=licencePlate;
        this.isAvailable=isAvailable;
    }
    public int getId(){
    return id;
    }
    public String getlicencePlate(){
    return licencePlate;
    }
    public boolean isAvailable(){
    return isAvailable;
    }
    public void setAvailable(boolean available){
    this.isAvailable=available;
    }
    public String toString(){
    String status = "Driver["+id+"]"+name+"("+licencePlate");
                if(isAvailable==true){
                    status=status+"[AVAILABLE]";
                }
                else{
                    status=status+"[BUSY]";
                }
                return status;
    }
    }