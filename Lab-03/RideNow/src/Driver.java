public class Driver {
    private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;

    public Driver(int id, String name, String licencePlate) {
        this.isAvailable = true;
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
    }

    public Driver(int id, String name, String licencePlate, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public String toString() {
        String ans = ("Driver" + "[" + id + "]" + " " + name + " " + "(" + licencePlate + ")" + " ");
        if (isAvailable) {
            ans += ("[AVAILABLE]");
        } else {
            ans += ("[BUSY]");
        }
        return ans;
    }


}
