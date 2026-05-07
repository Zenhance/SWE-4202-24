public class Driver {
    private int id;
    private String name;
    private String licensePlate;
    private boolean isAvailable;

    public Driver(int id, String name, String licencePlate){
        this.isAvailable = true;
        this.id = id;
        this.name = name;
        this.licensePlate = licencePlate;
    }

    public Driver(int id, String name, String licencePlate, boolean isAvailable){
        this.isAvailable = isAvailable;
        this.id = id;
        this.name = name;
        this.licensePlate = licencePlate;

    }

   public int getId(){
        return id;
   }

    public String getName() {
        return name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void setAvailable(boolean available){
        this.isAvailable = available;
    }

    public String toString(){
        if(isAvailable == true){
            return String.format("Driver %s (%s) [AVAILABLE]", name, licensePlate);
        }
        else{
            return String.format("Driver %s (%s) [BUSY]", name, licensePlate);

        }
    }
}
