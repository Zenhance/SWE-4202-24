public class Driver {

    private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable = true;

    Driver(int id, String name, String licencePlate){
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
    }

    Driver(int id, String name, String licencePlate, boolean isAvailable){
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = isAvailable;
    }

    public int getId(){
        int id = this.id;
        return id;
    }
    public String getName(){
        String name = this.name;
        return name;
    }
    public String getLicencePlate(){
        String licencePlate = this.licencePlate;
        return licencePlate;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public String toString(){

        String id_str = String.valueOf(id);
        String availability = null;
        if (isAvailable == true)
            availability = "[AVAILABLE]";
        else if (isAvailable == false)
            availability = "[BUSY]";

        String output = "Driver[";
        output = output.concat(id_str);
        output = output.concat("] ");
        output = output.concat(name);
        output = output.concat(" (");
        output = output.concat(licencePlate);
        output = output.concat(") ");
        output = output.concat(availability);

        return output;
    }

}
