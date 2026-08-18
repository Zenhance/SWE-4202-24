import java.util.List;

public abstract class Vehicle {
    private String numberPlate;
    private int hoursStayed;
    private DiscountScheme scheme;
    private SlotType type;
    public Vehicle(String numberPlate,int hoursStayed){
        this.numberPlate=numberPlate;
        this.hoursStayed=0;
        this.scheme=scheme;
        this.type=type;
    }

    public DiscountScheme getScheme() {
        return scheme;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public int getHoursStayed() {
        return hoursStayed;
    }

    public SlotType getType() {
        return type;
    }
    public void addHours(int hours){
        hoursStayed+=hours;
    }
    public abstract List<SlotType> acceptanceOrder();
}
