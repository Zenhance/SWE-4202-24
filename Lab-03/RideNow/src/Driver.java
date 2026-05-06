public class Driver {
    private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;

    Driver(int id,String name,String licensePlate){
        this.id=id;
        this.licensePlate=licensePlate;
        this.name=name;
    }
    Driver(int id,String name,String licensePlate,boolean isAvailable){
        this.id=id;
        this.licensePlate=licensePlate;
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
public String getLicensePlate(){
        return licensePlate;
}
public void setAvailable(boolean isAvailable){
        this.isAvailable=isAvailable;
}
public String toString(){
        if(isAvailable) {
            return "Driver" + "[" + id + "]" + name + "(" + licensePlate + ")" + "[AVAILABLE]";
        }
        else{
            return "Driver" + "[" + id + "]" + name + "(" + licensePlate + ")" + "[BUSY]";
        }
}

}
