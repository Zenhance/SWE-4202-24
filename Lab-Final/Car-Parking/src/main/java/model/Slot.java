package model;

public class Slot {
    private String type;
    private Vehicle vehicle;

    public Slot(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    public boolean free() {
        return vehicle == null;
    }

    public void park(Vehicle v) {
        vehicle = v;
    }

    public void remove() {
        vehicle = null;
    }
}
