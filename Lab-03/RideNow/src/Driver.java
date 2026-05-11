public class Driver {

    private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;

    public Driver(int id, String name, String licencePlate){
       this.id = id;
       this.name = name;
       this.licencePlate = licencePlate;
    }

    public Driver(int id, String name, String licencePlate, boolean isAvailable){
      this.id = id;
      this.name = name;
      this.licencePlate = licencePlate;
      this.isAvailable = isAvailable;
    }

    public void getId(){
        this.id = id;
    }
    public void getName(){
        this.name = name;
    }
    public void getLicencePlate(){
        this.licencePlate = licencePlate;
    }

    public void isAvailable(){
        this.isAvailable = isAvailable;
    }
}
