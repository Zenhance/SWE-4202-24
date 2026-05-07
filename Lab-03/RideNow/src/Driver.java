public class Driver {
    private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;

    Driver(int id,String name,String licencePlate){
        this.id=id;
        this.licencePlate=licencePlate;
        this.name=name;
        this.isAvailable=true;
    }
    Driver(int id,String name,String licencePlate,boolean isAvailable){
        this.id=id;
        this.licencePlate=licencePlate;
        this.name=name;
        this.isAvailable=isAvailable;
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
public String getLicencePlate(){
        return licencePlate;
}
public void setAvailable(boolean isAvailable){
        this.isAvailable=isAvailable;
}
public String toString(){
        if(isAvailable) {
            return "Driver" + "[" + id + "] " + name + " (" + licencePlate + ")" + " [AVAILABLE]";
        }
        else{
            return "Driver" + "[" + id + "] " + name + " (" + licencePlate + ")" + " [BUSY]";
        }
}

}
