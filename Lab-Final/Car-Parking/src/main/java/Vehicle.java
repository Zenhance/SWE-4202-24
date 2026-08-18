import java.util.List;

public abstract class Vehicle {

    private final String plate;
    private int hours = 0;

    protected Vehicle(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public int getHours() {
        return hours;
    }

    public int getBillableHours() {
        if (hours == 0) {
            return 1;
        }

        return hours;
    }

    public void addHours(int passedHours) {
        hours += passedHours;
    }

    public abstract List<SlotType> getAcceptedSlotTypes();

    public SlotType getHomeSlotType() {
        return getAcceptedSlotTypes().get(0);
    }
}