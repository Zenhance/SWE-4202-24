
public abstract class Vehicle {
    private String plate;
    private int time;
    private slotType slot;
    private schemeType scheme;

    public Vehicle(String plate, int time,slotType slot, schemeType scheme) {
        this.plate=plate;
        this.time=0;
        this.slot=slot;
        this.scheme=scheme;
    }

    public String getPlate() {
        return plate;
    }

    public int getTime() {
        return time;
    }

    public slotType getSlot() {
        return slot;
    }

    public schemeType getScheme() {
        return scheme;
    }
}
