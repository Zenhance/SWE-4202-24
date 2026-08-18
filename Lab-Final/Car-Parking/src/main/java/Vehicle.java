
public abstract class Vehicle {
    private String plate;
    private int time;
    private SlotType slot;
    private schemeType scheme;

    public Vehicle(String plate, int time,SlotType slot, schemeType scheme) {
        this.plate=plate;
        this.time=0;
        this.slot=slot;
        this.scheme=scheme;
    }

    public abstract SlotType[] occupiedSlot();


    public String getPlate() {
        return plate;
    }

    public int getTime() {
        return time;
    }

    public SlotType getSlot() {
        return slot;
    }

    public schemeType getScheme() {
        return scheme;
    }

}
