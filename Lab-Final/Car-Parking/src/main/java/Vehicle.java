
import java.util.List;

public abstract class Vehicle {
    private String numberPlate;
    private int hoursStayed;
    private Discount discount;
    private Slot slot;
    public Vehicle(String numberPlate,Discount discount){
        this.numberPlate=numberPlate;
        this.hoursStayed=0;
        this.discount=discount;
        this.slot=slot;
    }

    public Discount getDiscount() {
        return discount;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public int getHoursStayed() {
        return hoursStayed;
    }

    public Slot getSlot() {
        return slot;
    }

    public void addHours(int hours){
        hoursStayed+=hours;
    }
    public abstract List<Slot> acceptanceOrder();

}