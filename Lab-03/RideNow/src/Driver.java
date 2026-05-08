public class Driver{
    private int id;
    private String name;
    private String licensePlate;
    private boolean isAvailable;

    public Driver(int id, String name, String licensePlate){
        this.id=id;
        this.name=name;
        this.licensePlate=licensePlate;
        isAvailable=true;

    }

    public Driver(int id, String name, String licensePlate, boolean isAvailable){
        this.id=id;
        this.name=name;
        this.licensePlate=licensePlate;
        this.isAvailable=isAvailable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }


    public void setAvailable(boolean available){
        this.isAvailable=available;
    }


    public String toString(){
        String res ="Driver["+id+"]"+name+"("+licensePlate+")";
        if(isAvailable==true){
           res=res+"[AVAILABLE]";
        }else{
            res=res+"[BUSY]";
        }

         return res;
    }
}
